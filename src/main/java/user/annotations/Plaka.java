package user.annotations;

import jakarta.validation.Payload;

public @interface Plaka {
    String message() default "Geçersiz Plaka";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
