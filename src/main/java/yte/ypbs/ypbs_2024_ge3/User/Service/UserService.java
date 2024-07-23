package yte.ypbs.ypbs_2024_ge3.User.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.User.Controller.UserResponse;
import yte.ypbs.ypbs_2024_ge3.User.Entity.User;
import yte.ypbs.ypbs_2024_ge3.User.Repository.UserRepository;

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

    public User createUser(String name, String surname, String birthDate, byte[] image) {
        LocalDate birthDateParsed = LocalDate.parse(birthDate);
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setBirthDate(birthDateParsed);
        user.setImage(image);
        return userRepository.save(user);
    }
}
