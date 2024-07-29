package yte.ypbs.ypbs_2024_ge3.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest.username(), loginRequest.password());
    }

    @GetMapping("/logout")
    public String logout(){
        authenticationService.logout();
        return "Logout successful";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/test")
    public String test(){
        return "Allahım User ";
    }

}
