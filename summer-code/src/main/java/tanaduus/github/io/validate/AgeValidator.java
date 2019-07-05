package tanaduus.github.io.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<IsAge, Integer> {
    @Override
    public void initialize(IsAge isAge) {

    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return 0 < age && age < 200;
    }
}
