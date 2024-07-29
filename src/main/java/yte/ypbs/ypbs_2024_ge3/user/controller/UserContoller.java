package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.user.response.UserResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

@RestController("/api")
public class UserContoller {

    private UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserResponse getUser() {
        return new UserResponse(userService.getUser());
    }
}
