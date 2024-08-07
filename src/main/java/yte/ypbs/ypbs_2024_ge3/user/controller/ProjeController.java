package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.ProjeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjeController {

    private final ProjeService projeService;

    public ProjeController(ProjeService projeService) {
        this.projeService = projeService;
    }

    @GetMapping("/proje")
    public List<UsersProjeResponse> getUserProje() {
        return projeService.getUserProje();
    }

}
