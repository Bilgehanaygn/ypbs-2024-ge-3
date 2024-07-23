package yte.ypbs.ypbs_2024_ge3.login.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.ypbs.ypbs_2024_ge3.login.entity.Authority;
import yte.ypbs.ypbs_2024_ge3.login.entity.CustomUser;
import yte.ypbs.ypbs_2024_ge3.login.repository.CustomUserRepository;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class TempDatabasePopulate {

    private final CustomUserRepository customUserRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void populate() {
        CustomUser user = new CustomUser("user1", passwordEncoder.encode("123"), List.of(new Authority("ROLE_USER")));
        CustomUser admin = new CustomUser("admin2", passwordEncoder.encode("123"), List.of(new Authority("ROLE_ADMIN")));
        customUserRepository.saveAll(List.of(user, admin));
    }

}
