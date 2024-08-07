package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersEgitimResponse;
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
    public List<UsersEgitimResponse> getUserEgitim() {
        return egitimService.getUserEgitim();
    }

    @GetMapping("/egitim/enum")
    public List<String> getEgitimEnums() {
        return egitimService.getEgitimEnums();
    }

    @PostMapping("/egitim")
    public void addUserEgitim(@RequestBody EgitimRequest egitimRequest) {
        egitimService.addUserEgitim(egitimRequest);
    }

    @PutMapping("/egitim/{id}")
    public void updateUserEgitim(@PathVariable Long id, @RequestBody EgitimRequest egitimRequest) {
        egitimService.updateUserEgitim(id, egitimRequest);
    }

    @DeleteMapping("/egitim/{id}")
    public void deleteUserEgitim(@PathVariable Long id) {
        egitimService.deleteUserEgitim(id);
    }
}