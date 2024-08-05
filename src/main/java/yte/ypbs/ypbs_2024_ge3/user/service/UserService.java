package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;

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


    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return user;
    }

    public User getUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return user;
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
