package mastery.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public final class BirthDateValidator implements ConstraintValidator<DateOfBirthValidation, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        LocalDate dateTime = LocalDate.now().minusYears(18);
        return value.isBefore(dateTime);
    }
}
