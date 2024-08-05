//package yte.ypbs.ypbs_2024_ge3.login.configuration;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import yte.ypbs.ypbs_2024_ge3.login.entity.Authority;
//import yte.ypbs.ypbs_2024_ge3.user.entity.User;
//import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
//
//import java.util.List;
//
//@Configuration
//public class TempDatabasePopulate {
//
//    private PasswordEncoder passwordEncoder;
//    private UserRepository userRepository;
//
//    public TempDatabasePopulate(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//
//    @PostConstruct
//    public void populate() {
//        User user = new User("a", "a", "user", passwordEncoder.encode("123"), "a@a.com", "a", List.of(new Authority("ROLE_USER")));
//        User admin = new User("a", "a", "admin", passwordEncoder.encode("123"), "a@a.com", "a", List.of(new Authority("ROLE_ADMIN")));
//        userRepository.saveAll(List.of(user, admin));
//    }
//}
