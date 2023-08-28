package validate;

import dto.request.Request;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CheckValid {
    @Inject
    Validator validator;

    public Result manualValidation(Request request) {
        Set<ConstraintViolation<Request>> violations = validator.validate(request);
        if (violations.isEmpty()) {
            return new Result("Request is valid!");
        } else {
            return new Result(violations);
        }
    }


    public static class Result {

        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        private String message;
        private boolean success;

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }

    }
}
