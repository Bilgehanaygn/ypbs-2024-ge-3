package yte.ypbs.ypbs_2024_ge3.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/login")
@RequiredArgsConstructor
public class UserController_SampleForLogin {

    @GetMapping
    public String login(@RequestParam final String username,
                        final String password) {
        return "Username: " + username + "\nPassword: " + password;
    }


}
