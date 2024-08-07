package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDosyaRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.DosyaService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DosyaController {

    private final DosyaService dosyaService;

    public DosyaController(DosyaService dosyaService) {
        this.dosyaService = dosyaService;
    }

    @GetMapping("/dosya")
    public List<UsersDosyaDetailResponse> getUserDosya(){
        return dosyaService.getUserDosyaDetails();
    }

    @GetMapping("/dosya/download/{id}")
    public void downloadUserDosya(){

    }

    @PostMapping(value = "/dosya/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String uploadUserDosya(@ModelAttribute UsersDosyaRequest usersDosyaRequest){
        try {
            dosyaService.storeUserDosya(usersDosyaRequest);
            return ("File uploaded successfully");
        } catch (IOException e) {
            return ("Could not upload the file: " + e.getMessage());
        }
    }
}
