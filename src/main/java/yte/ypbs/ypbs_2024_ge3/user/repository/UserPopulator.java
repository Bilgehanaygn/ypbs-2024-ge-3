package yte.ypbs.ypbs_2024_ge3.user.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;

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
        User user1 = new User("John", "Doe", "password", "JohnDoe@email.com", "1234567890", LocalDate.of(2020, 7, 24), null);
        User user2 = new User("Jane", "Doe", "password", "JaneDoe@email.com", "1234567890", LocalDate.of(2024, 7, 24), null);
        User user3 = new User("Alice", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2000, 3, 3), null);
        User user4 = new User("Bob", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        User user5 = new User("Yoo", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        User user6 = new User("Alex", "Doe", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        User user7 = new User("Alex", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        User user8 = new User("Card", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        User user9 = new User("Ophelia", "Doe", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);
        User user10 = new User("Miria", "Smith", "password", "mail@asd", "1234567890", LocalDate.of(2005, 4, 4), null);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);

//        kurumsalRepository.save(new Kurumsal(user1, LocalDate.now(), 2L, "İş Analisti", "Uzman Yazılımcı", "Yazılım Geliştirme", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user2, LocalDate.now(), 2L, "İş Analisti", "Yazılımcı", "Donanım ", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user3, LocalDate.now(), 2L, "İş Analisti", "Uzman Araştırmacı", "Yazılım Geliştirme", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user4, LocalDate.now(), 2L, "İş Analisti", "Uzman Yazılımcı", "Yazılım Geliştirme", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user5, LocalDate.now(), 2L, "İş Analisti", "Uzman Araştırmacı", "Yazılım Geliştirme", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user6, LocalDate.now(), 2L, "İş Analisti", "Uzman Yazılımcı", "Donanım", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user7, LocalDate.now(), 2L, "İş Analisti", "Uzman Yazılımcı", "Yazılım Geliştirme", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user8, LocalDate.now(), 2L, "İş Analisti", "Uzman Yazılımcı", "Yazılım Geliştirme", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user9, LocalDate.now(), 2L, "İş Analisti", "Uzman Araştırmacı", "Donanım", "YPBS"));
//        kurumsalRepository.save(new Kurumsal(user10, LocalDate.now(), 2L, "İş Analisti", "Uzman Yazılımcı", "Yazılım Geliştirme", "YPBS"));
    }
}
