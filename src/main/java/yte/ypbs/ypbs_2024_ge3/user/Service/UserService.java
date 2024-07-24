package yte.ypbs.ypbs_2024_ge3.user.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.Controller.UserBornTodayResponse;
import yte.ypbs.ypbs_2024_ge3.user.Controller.UserDataGridResponse;
import yte.ypbs.ypbs_2024_ge3.user.Entity.User;
import yte.ypbs.ypbs_2024_ge3.user.Repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserBornTodayResponse> getAllBornToday() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        List<User> users = userRepository.findByBirthdayMonthAndDay(month, day);
        List<UserBornTodayResponse> userBornTodayResponses = new ArrayList<>();
        for (User user : users) {
            userBornTodayResponses.add(UserBornTodayResponse.fromEntity(user));
        }
        return userBornTodayResponses;
    }

    public List<UserDataGridResponse> searchUsersWithFilters(String nameSurname,
                                                             String unvan,
                                                             String gorev,
                                                             String birim,
                                                             String proje) {
        List<Map<String, Object>> queryResult = userRepository.searchUsersWithFilters(nameSurname, unvan, gorev, birim, proje);
        List<UserDataGridResponse> result = new ArrayList<>();

        for (Map<String, Object> row : queryResult) {
            UserDataGridResponse userDataGridResponse = new UserDataGridResponse(
                    (String) row.get("nameSurname"),
                    (String) row.get("unvan"),
                    (String) row.get("gorev"),
                    (String) row.get("birim"),
                    (String) row.get("proje"),
                    (String) row.get("email"),
                    (String) row.get("telefon")
            );
            result.add(userDataGridResponse);
        }
        return result;
    }

    public User createUser(String name, String surname, String password, String email, String telefon, String birthDate, byte[] image) {
        LocalDate birthDateParsed = LocalDate.parse(birthDate);
        User user = new User(name, surname, password, email, telefon, birthDateParsed, image);
        return userRepository.save(user);
    }
}
