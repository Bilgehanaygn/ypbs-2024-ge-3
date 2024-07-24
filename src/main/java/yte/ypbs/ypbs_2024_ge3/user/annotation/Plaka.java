package yte.ypbs.ypbs_2024_ge3.user.annotation;

import jakarta.validation.Payload;

public @interface Plaka {
    String message() default "Geçersiz Plaka";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
