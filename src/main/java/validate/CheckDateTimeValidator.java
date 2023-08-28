package validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class CheckDateTimeValidator implements ConstraintValidator<CheckDateTime, LocalDateTime> {
    @Override
    public void initialize(CheckDateTime constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDateTime dtm, ConstraintValidatorContext cxt) {
        Pattern pattern = Pattern.compile("\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])T([01]?[0-9]|2[0-3]):[0-5][0-9]");
        return pattern.matcher(dtm.toString()).matches();
    }
}
