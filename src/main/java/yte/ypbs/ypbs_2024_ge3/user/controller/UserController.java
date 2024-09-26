package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserKisiselResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userKisisel")
    public UserKisiselResponse getUserKisisel() {
        return userService.findByUsernameKisisel();
    }

    @GetMapping("/userHeader")
    public UserHeaderResponse getUserHeader() {
        return userService.findByUsername();
    }


    @GetMapping("/findUsersWithFilters")
    public List<UserDataResponse> findUsersWithFilters(String nameSurname,
                                                          String unvan,
                                                          String gorev,
                                                          String birim,
                                                          String proje,
                                                          String takim) {
        return userService.findUsersWithFilters(nameSurname, unvan, gorev, birim, proje, takim);
    }



}
