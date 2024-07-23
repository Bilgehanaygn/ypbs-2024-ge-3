package yte.ypbs.ypbs_2024_ge3.user.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PlakaValidator implements ConstraintValidator<Plaka, String> {

    private static final String PLATE_PATTERN = "^(0[1-9]|[1-7][0-9]|8[0-1]) [A-Z]{1,3} [0-9]{1,4}$";

    private final Pattern pattern = Pattern.compile(PLATE_PATTERN);

    @Override
    public void initialize(Plaka constraintAnnotation) {
    }

    @Override
    public boolean isValid(String plaka, ConstraintValidatorContext context) {
        if (plaka == null) {
            return false;
        }
        return pattern.matcher(plaka).matches();
    }
}

