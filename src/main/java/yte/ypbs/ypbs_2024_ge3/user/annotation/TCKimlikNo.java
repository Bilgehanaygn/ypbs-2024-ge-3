package yte.ypbs.ypbs_2024_ge3.user.annotation;

import jakarta.validation.Payload;

public @interface TCKimlikNo {
    String message() default "Geçersiz TC Kimlik No";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
