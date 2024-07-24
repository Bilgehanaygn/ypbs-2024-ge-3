package yte.ypbs.ypbs_2024_ge3.user.annotations;

import jakarta.validation.Payload;

public @interface Telefon {
    String message() default "Geçersiz Telefon";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
