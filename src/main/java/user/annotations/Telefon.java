package user.annotations;

import jakarta.validation.Payload;

public @interface Telefon {
    String message() default "Geçersiz Telefon";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
