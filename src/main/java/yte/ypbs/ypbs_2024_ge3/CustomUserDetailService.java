package yte.ypbs.ypbs_2024_ge3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUser;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUserRepository;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomUserRepository customUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customUserRepository.findByUsername(username);
    }
}
