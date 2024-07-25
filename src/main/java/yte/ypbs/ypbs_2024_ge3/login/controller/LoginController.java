package yte.ypbs.ypbs_2024_ge3.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.login.request.LoginRequest;
import yte.ypbs.ypbs_2024_ge3.login.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private AuthenticationService authenticationService;

    @Autowired
    LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String login(){
        return "Login Sayfası";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest.username(), loginRequest.password());
    }

}
