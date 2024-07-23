package yte.ypbs.ypbs_2024_ge3.User.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import yte.ypbs.ypbs_2024_ge3.User.Entity.User;

import java.time.LocalDate;

@Configuration
public class UserPopulator {
    private final UserRepository userRepository;

    @Autowired
    public UserPopulator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void populateUsers() {
        userRepository.save(new User("John", "Doe", LocalDate.of(2020, 07, 23)));
        userRepository.save(new User("Jane", "Doe", LocalDate.of(2024, 7, 23)));
        userRepository.save(new User("Alice", "Smith", LocalDate.of(2000, 3, 3)));
        userRepository.save(new User("Bob", "Smith", LocalDate.of(2005, 4, 4)));
    }
}
