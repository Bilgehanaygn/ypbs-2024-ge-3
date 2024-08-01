package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.response.UserHeaderResponse;
import yte.ypbs.ypbs_2024_ge3.user.response.UserResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userHeader")
    public UserHeaderResponse getUserHeader() {
        return userService.findByUsername();
    }

    @GetMapping("/getuser")
    public UserResponse getUser() {
        return new UserResponse(userService.getUser());
    }
}
