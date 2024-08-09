package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersProjeRequest;
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

    @PostMapping("/proje")
    public void addUserProje(@RequestBody UsersProjeRequest projeRequest) {
        projeService.addUserProje(projeRequest);
    }

    @PutMapping("/proje/{id}")
    public void updateUserProje(@PathVariable Long id, @RequestBody UsersProjeRequest projeRequest) {
        projeService.updateUserProje(id, projeRequest);
    }

    @DeleteMapping("/proje/{id}")
    public void deleteUserProje(@PathVariable Long id) {
        projeService.deleteUserProje(id);
    }

}
