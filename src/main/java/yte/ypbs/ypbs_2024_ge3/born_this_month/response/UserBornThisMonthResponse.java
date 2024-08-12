package yte.ypbs.ypbs_2024_ge3.born_this_month.response;

import java.time.LocalDate;

public record UserBornThisMonthResponse(String name,
                                        String surname,
                                        byte[] photo,
                                        LocalDate birthDate) {
}
