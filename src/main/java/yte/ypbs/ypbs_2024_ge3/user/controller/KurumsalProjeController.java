package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.KurumsalProjeService;
import yte.ypbs.ypbs_2024_ge3.user.service.KurumsalService;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/kurumsalProje")
public class KurumsalProjeController {

    private KurumsalProjeService kurumsalProjeService;

    public KurumsalProjeController(KurumsalProjeService kurumsalProjeService) {
        this.kurumsalProjeService = kurumsalProjeService;
    }

    @GetMapping("/getGorevs")
    public List<String> getGorevs() {
        return kurumsalProjeService.findGorevs();
    }

}
