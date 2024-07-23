package yte.ypbs.ypbs_2024_ge3.user.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TCKimlikNoValidator implements ConstraintValidator<TCKimlikNo, String> {

    @Override
    public void initialize(TCKimlikNo constraintAnnotation) {
    }

    @Override
    public boolean isValid(String tckimlikno, ConstraintValidatorContext context) {
        if (tckimlikno == null || tckimlikno.length() != 11 || !tckimlikno.matches("[0-9]+")) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(tckimlikno.charAt(i));
        }
        if ((digits[10] % 2 == 1) || (digits[0] == 0)) {
            return false;
        }

        int sumOdd = digits[0] + digits[2] + digits[4] + digits[6] + digits[8];
        int sumEven = digits[1] + digits[3] + digits[5] + digits[7];

        int checkDigit1 = (7 * sumOdd - sumEven) % 10;
        int checkDigit2 = (sumOdd + sumEven + digits[9]) % 10;

        return checkDigit1 == digits[9] && checkDigit2 == digits[10];
    }
}

