package yte.ypbs.ypbs_2024_ge3.user.Controller;

import yte.ypbs.ypbs_2024_ge3.user.Entity.User;

import java.time.LocalDate;

public record UserResponse(
        String name,
        String surname,
        LocalDate birthDate,
        byte[] image
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getIsim(),
                user.getSoyisim(),
                user.getDogumTarihi(),
                user.getImage()
        );
    }
}
