package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
import yte.ypbs.ypbs_2024_ge3.user.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.response.EgitimResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.EgitimService;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EgitimController {

    private final UserService userService;
    private EgitimService egitimService;
    private UserRepository userRepository;

    public EgitimController(EgitimService egitimService, UserRepository userRepository, UserService userService) {
        this.egitimService = egitimService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/egitim")
    public List<EgitimResponse> getUser() {
        return egitimService.getUserEgitim().stream().map(Egitim::toEgitimResponse).toList();
    }

    @PutMapping("/egitim")
    public void updateUser(@RequestBody List<EgitimRequest> egitimRequest) {
        egitimService.updateUserEgitim(egitimRequest);
    }

    @DeleteMapping("/egitim/{id}")
    public void deleteUser(@PathVariable long id) {
        egitimService.deleteUserEgitim(id);
    }
}