package user.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class TelefonValidator implements ConstraintValidator<Telefon, String> {

    private static final String TELEFON_PATTERN = "^05[0-9]{9}$";

    private final Pattern pattern = Pattern.compile(TELEFON_PATTERN);

    @Override
    public void initialize(Telefon constraintAnnotation) {
    }

    @Override
    public boolean isValid(String telefon, ConstraintValidatorContext context) {
        if (telefon == null) {
            return false;
        }
        return pattern.matcher(telefon).matches();
    }
}

