package mastery.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
@Documented
public @interface GenderValidation {
    Class<? extends Enum<?>> enumClazz();

    String message() default "Employee must be mail or female.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
