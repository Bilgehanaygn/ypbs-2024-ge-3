package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
import yte.ypbs.ypbs_2024_ge3.user.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.response.UserHeaderResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserHeaderResponse findByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() == null || authentication.getPrincipal().equals("anonymousUser")) return null;
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return user.toUserHeaderResponse();
    }


    public List<UserDataResponse> findUsersWithFilters(String nameSurname,
                                                       String unvan,
                                                       String gorev,
                                                       String birim,
                                                       String proje) {
        List<User> result = userRepository.findUsersWithFilters(nameSurname, birim, unvan, gorev, proje);
        return result.stream()
                .map(User::toUserDataResponse)
                .collect(Collectors.toList());
    }
}

