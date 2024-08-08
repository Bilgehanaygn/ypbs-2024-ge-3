package yte.ypbs.ypbs_2024_ge3.login.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.ypbs.ypbs_2024_ge3.login.entity.Authority;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru.*;

@Configuration
public class TempDatabasePopulate {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public TempDatabasePopulate(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void populate() {

        User user = new User (Set.of(new Egitim(LISE, "metu", "3", LocalDate.of(2020, 12, 2), LocalDate.of(2020, 12, 2), "sdgsdg"),
                new Egitim(ILKOKUL, "lise", "a", LocalDate.of(2020,12,2), LocalDate.of(2020,12,2),"okulum"),
                new Egitim(LISANS, "uni", "tarak", LocalDate.of(2020,12,2), LocalDate.of(2020,12,2), "merahabaşlar uzun text denemsi sacma seyler yazıom")),
                "a", "a", "user", passwordEncoder.encode("123"), "a@a.com", "a", List.of(new Authority("ROLE_USER")));


        User admin = new User (
                Set.of(
                        new Egitim(LISE, "de", "sgjsjgsfj", LocalDate.of(2020, 12, 2), LocalDate.of(2020, 12, 2), "sdgsdg"),
                        new Egitim(ILKOKUL, "de", "fafaf", LocalDate.of(2020,12,2), LocalDate.of(2020,12,2),"gasdgsd"),
                        new Egitim(LISANS, "asfadsfdaf", "adgadgad", LocalDate.of(2020,12,2), LocalDate.of(2020,12,2),"gasdgsd")),
                "as", "ae", "admin", passwordEncoder.encode("123"), "a@a.com", "a", List.of(new Authority("ROLE_ADMIN")));

        userRepository.saveAll(List.of(user, admin));
    }
}
