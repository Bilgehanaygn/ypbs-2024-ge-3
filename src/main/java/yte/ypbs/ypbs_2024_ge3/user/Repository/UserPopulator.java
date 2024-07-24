package yte.ypbs.ypbs_2024_ge3.user.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yte.ypbs.ypbs_2024_ge3.user.Entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.Entity.User;

import java.time.LocalDate;

@Configuration
public class UserPopulator {
    private final UserRepository userRepository;
    private final KurumsalRepository kurumsalRepository;

    @Autowired
    public UserPopulator(UserRepository userRepository , KurumsalRepository kurumsalRepository) {
        this.userRepository = userRepository;
        this.kurumsalRepository = kurumsalRepository;
    }

    @PostConstruct
    public void populateUsers() {
        userRepository.save(new User("John", "Doe", "password", "JohnDoe@email.com", "1234567890", LocalDate.of(2020, 7, 24), null));
        userRepository.save(new User("Jane", "Doe", "password", "JaneDoe@email.com", "1234567890", LocalDate.of(2024, 7, 24), null));
        userRepository.save(new User("Alice", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2000, 3, 3), null));
        userRepository.save(new User("Bob", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null));
        User u = new User("Yoo", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        userRepository.save(u);
        kurumsalRepository.save(new Kurumsal(u, "Bilge Adam", "Yazılım", "sad", "asd"));
        User u2 = new User("Yoo", "Smith", "password", "mail@asd", "5555", LocalDate.of(2005, 4, 4), null);
        userRepository.save(u2);
        kurumsalRepository.save(new Kurumsal(u2, "Bilge Adam", "Yazılım", "sad", "asd"));
    }
}
