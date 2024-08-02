package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.response.EgitimResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.EgitimService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EgitimController {

    private final EgitimService egitimService;

    public EgitimController(EgitimService egitimService) {
        this.egitimService = egitimService;
    }

    @GetMapping("/egitim")
    public List<EgitimResponse> getUser() {
        return egitimService.getUserEgitim();
    }

    @GetMapping("/egitim/enum")
    public List<String> getEgitimEnums() {
        return egitimService.getEgitimEnums();
    }

    @PutMapping("/egitim/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody EgitimRequest egitimRequest) {
        egitimService.updateUserEgitim(id, egitimRequest);
    }

    @DeleteMapping("/egitim/{id}")
    public void deleteUser(@PathVariable Long id) {
        egitimService.deleteUserEgitim(id);
    }
}