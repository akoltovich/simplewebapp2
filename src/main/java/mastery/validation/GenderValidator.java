package mastery.validation;


import mastery.dto.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public final class GenderValidator implements ConstraintValidator<GenderValidation, Gender> {

    List<String> valueList = null;

    @Override
    public void initialize(GenderValidation constraintAnnotation) {
        valueList = new ArrayList<>();
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();
        @SuppressWarnings("rawtypes")
        Enum[] enumValArr = enumClass.getEnumConstants();

        for (@SuppressWarnings("rawtypes") Enum enumVal : enumValArr) {
            valueList.add(enumVal.toString().toUpperCase());
        }
    }

    @Override
    public boolean isValid(Gender value, ConstraintValidatorContext context) {
        return valueList.contains(value.toString().toUpperCase());
    }
}
