package yte.ypbs.ypbs_2024_ge3.User.Controller;

import yte.ypbs.ypbs_2024_ge3.User.Entity.User;

import java.time.LocalDate;

public record UserResponse(
        String name,
        String surname,
        LocalDate birthDate,
        byte[] image
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getName(),
                user.getSurname(),
                user.getBirthDate(),
                user.getImage()
        );
    }
}
