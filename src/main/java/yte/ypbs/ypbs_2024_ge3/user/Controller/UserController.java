package yte.ypbs.ypbs_2024_ge3.user.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import yte.ypbs.ypbs_2024_ge3.user.Entity.User;
import yte.ypbs.ypbs_2024_ge3.user.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/born-today")
    public List<UserResponse> getAllBornToday() {
        return userService.getAllBornToday();
    }

    @PostMapping("/create-user")
    public User createUser(String name, String surname, String birthDate, MultipartFile imageFile) {
        byte[] image = null;
        try {
            image = imageFile.getBytes();
        } catch (Exception e) {
            throw new RuntimeException("Could not read image file");
        }

        return userService.createUser(name, surname, birthDate, image);
    }
}
