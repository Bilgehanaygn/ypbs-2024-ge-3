package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.KurumsalService;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/kurumsal")
public class KurumsalController {

    private KurumsalService kurumsalService;

    public KurumsalController(KurumsalService kurumsalService) {
        this.kurumsalService = kurumsalService;
    }

    @GetMapping("/getUnvans")
    public List<String> getUnvans() {
        return kurumsalService.findUnvans();
    }

    @GetMapping("/getBirims")
    public List<String> getBirims() {
        return kurumsalService.findBirims();
    }


}
