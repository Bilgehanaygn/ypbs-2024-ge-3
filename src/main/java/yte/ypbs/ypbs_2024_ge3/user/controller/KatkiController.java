package yte.ypbs.ypbs_2024_ge3.user.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersKatkiRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersKatkiDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersKatkiFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.KatkiService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KatkiController {

    private final KatkiService katkiService;

    public KatkiController(KatkiService katkiService) {
        this.katkiService = katkiService;
    }

    @GetMapping("/katki")
    public List<UsersKatkiDetailResponse> getKatki() {
        return katkiService.getUserKatkiDetails();
    }

    @GetMapping("katki/enum")
    public List<String> getKatkiEnum() {
        return katkiService.getKatkiEnums();
    }

    @GetMapping("/katki/download/{id}")
    public void downloadUserKatki(@PathVariable Long id, HttpServletResponse response) throws IOException {

//        return katkiService.getUserKatkiFile(id).ek(); //Change Retrun type

        try {
            UsersKatkiFileResponse fileResponse = katkiService.getUserKatkiFile(id);

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileResponse.ekAdi() + "\"");
            response.getOutputStream().write(fileResponse.ek());
            response.getOutputStream().flush();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }

    @PostMapping(value = "/katki/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void uploadUserKatki(@ModelAttribute UsersKatkiRequest katkiRequest) {
        try {
            katkiService.addUserKatki(katkiRequest);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping(value = "/katki/upload/{id}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateUserKatki(@PathVariable Long id, @ModelAttribute UsersKatkiRequest katkiRequest) {
        katkiService.updateUserKatki(id, katkiRequest);
    }

    @DeleteMapping("/katki/{id}")
    public void deleteUserKatki(@PathVariable Long id) {
        katkiService.deleteUserKatki(id);
    }
}
