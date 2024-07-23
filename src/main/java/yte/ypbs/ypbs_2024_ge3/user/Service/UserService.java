package yte.ypbs.ypbs_2024_ge3.user.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.Controller.UserResponse;
import yte.ypbs.ypbs_2024_ge3.user.Entity.User;
import yte.ypbs.ypbs_2024_ge3.user.Repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponse> getAllBornToday() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        List<User> users = userRepository.findByBirthdayMonthAndDay(month, day);
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(UserResponse.fromEntity(user));
        }
        return userResponses;
    }

    public User createUser(String name, String surname, String password, String email, String telefon, String birthDate, byte[] image) {
        LocalDate birthDateParsed = LocalDate.parse(birthDate);
        User user = new User(name, surname, password, email, telefon, birthDateParsed, image);
        return userRepository.save(user);
    }
}
