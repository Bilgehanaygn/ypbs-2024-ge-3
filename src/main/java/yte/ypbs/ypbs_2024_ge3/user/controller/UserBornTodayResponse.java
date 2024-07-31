package yte.ypbs.ypbs_2024_ge3.user.controller;

import yte.ypbs.ypbs_2024_ge3.user.entity.User;

import java.time.LocalDate;

public record UserBornTodayResponse(
        String name,
        String surname,
        LocalDate birthDate,
        byte[] image
) {
    public static UserBornTodayResponse fromEntity(User user) {
        return new UserBornTodayResponse(
                user.getIsim(),
                user.getSoyisim(),
                user.getDogumTarihi(),
                user.getImage()
        );
    }
}
