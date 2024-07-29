package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.response.EgitimResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.EgitimService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class EgitimController {

    private EgitimService egitimService;

    public EgitimController(EgitimService egitimService) {
        this.egitimService = egitimService;
    }

    @GetMapping("/egitim")
    public List<EgitimResponse> getUser() {

        Set<Egitim> egitimler = egitimService.getUserEgitim("user");

        List<EgitimResponse> egitimResponse = egitimler.stream().map(egitim -> {
            return new EgitimResponse(
                    egitim.getEgitimTuru().toString(),
                    egitim.getOkulAdi(),
                    egitim.getBolum(),
                    egitim.getBaslangicTarihi().toString(),
                    egitim.getMezuniyetTarihi().toString(),
                    egitim.getAciklama());
        }).toList();

        return egitimResponse;
    }

    @PutMapping
    public void updateUser(@RequestBody EgitimResponse egitimResponse) {
        System.out.println("updateUser: " + egitimResponse);
    }
}
