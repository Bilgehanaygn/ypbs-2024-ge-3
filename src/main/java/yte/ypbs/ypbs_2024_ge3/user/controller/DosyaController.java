package yte.ypbs.ypbs_2024_ge3.user.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDosyaRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.DosyaService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/dosya")
public class DosyaController {

    private final DosyaService dosyaService;

    public DosyaController(DosyaService dosyaService) {
        this.dosyaService = dosyaService;
    }


    @GetMapping()
    public List<UsersDosyaDetailResponse> getUserDosya() {
        return dosyaService.getUserDosyaDetails();
    }

    @GetMapping("/enum")
    public List<String> getDosyaEnum() {
        return dosyaService.getDosyaEnums();
    }

    @GetMapping("/download/{id}")
    public void downloadUserDosya(@PathVariable Long id, HttpServletResponse response) throws IOException {

//        return dosyaService.getUserDosyaFile(id).dosya(); // return type'ı byte[] yapıp kullanaılabilir

        try {
            UsersDosyaFileResponse fileResponse = dosyaService.getUserDosyaFile(id);

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileResponse.dosyaAdi() + "\"");
            response.getOutputStream().write(fileResponse.dosya());
            response.getOutputStream().flush();

        } catch (IOException e) {
            throw new RuntimeException("Fail", e);
        }
    }

    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String uploadUserDosya(@ModelAttribute UsersDosyaRequest usersDosyaRequest) {
        try {
            dosyaService.storeUserDosya(usersDosyaRequest);
            return ("File uploaded successfully");
        } catch (IOException e) {
            return ("Could not upload the file: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserDosya(@PathVariable Long id) {
        dosyaService.deleteUserDosya(id);
    }
}
