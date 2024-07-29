package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;

import java.util.Set;

@Service
public class EgitimService {
    private final UserService userService;

    public EgitimService(UserService userService) {
        this.userService = userService;
    }

    public Set<Egitim> getUserEgitim() {

        User user = userService.getUser();
        Set<Egitim> egitimSet = user.getEgitim();

        return egitimSet;
    }

    public Set<Egitim> getUserEgitim(String username) {

        User user = userService.getUser(username);
        Set<Egitim> egitimSet = user.getEgitim();

        return egitimSet;
    }

}
