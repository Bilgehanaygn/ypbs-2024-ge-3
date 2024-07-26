package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.response.EgitimResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.EgitimService;

@RestController
@RequestMapping("/auth")
public class EgitimController {

    private EgitimService egitimService;

    public EgitimController(EgitimService egitimService) {
        this.egitimService = egitimService;
    }

    @GetMapping("/egitim")
    public EgitimResponse getUser() {
        return new EgitimResponse(egitimService.getUserEgitim());
    }
}
