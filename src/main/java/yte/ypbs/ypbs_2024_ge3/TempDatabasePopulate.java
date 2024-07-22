package yte.ypbs.ypbs_2024_ge3;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.Authority.Authority;
import yte.ypbs.ypbs_2024_ge3.Authority.AuthorityRepository;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUser;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUserRepository;

import java.util.List;

@Configuration
public class TempDatabasePopulate {

    private CustomUserRepository customUserRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public TempDatabasePopulate(CustomUserRepository customUserRepository, BCryptPasswordEncoder passwordEncoder) {
        this.customUserRepository = customUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void populate() {
        CustomUser user = new CustomUser("user1", passwordEncoder.encode("123"), List.of(new Authority("ROLE_USER")));
        CustomUser admin = new CustomUser("admin2", passwordEncoder.encode("123"), List.of(new Authority("ROLE_ADMIN")));
        customUserRepository.saveAll(List.of(user, admin));
    }

}
