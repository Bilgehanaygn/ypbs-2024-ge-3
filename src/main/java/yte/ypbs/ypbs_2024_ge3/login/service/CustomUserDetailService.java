package yte.ypbs.ypbs_2024_ge3.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.login.repository.CustomUserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private CustomUserRepository customUserRepository;

    @Autowired
    CustomUserDetailService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Couldn't find %s".formatted(username)));
    }
}
