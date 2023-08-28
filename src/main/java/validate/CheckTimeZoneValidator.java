package validate;

import enums.TimeZone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CheckTimeZoneValidator implements ConstraintValidator<CheckTimeZone, Object> {

    @Override
    public void initialize(CheckTimeZone constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext cxt) {
        return Arrays.toString(TimeZone.values()).contains(obj.toString());
    }
}
