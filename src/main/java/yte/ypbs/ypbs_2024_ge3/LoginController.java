package yte.ypbs.ypbs_2024_ge3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "Login Sayfası";
    }

}
