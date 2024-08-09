package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.KurumsalService;
import yte.ypbs.ypbs_2024_ge3.user.service.ProjeService;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/proje")
public class ProjeController {

    private ProjeService projeService;

    public ProjeController(ProjeService projeService) {
        this.projeService = projeService;
    }

    @GetMapping("/getNames")
    public List<String> getUnvans() {
        return projeService.findNames();
    }

    @GetMapping("/getTeams")
    public List<String> getBirims() {
        return projeService.findTeams();
    }


}
