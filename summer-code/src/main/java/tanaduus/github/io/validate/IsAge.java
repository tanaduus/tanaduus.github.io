package tanaduus.github.io.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AgeValidator.class})
public @interface IsAge {

    boolean required() default true;

    String message() default "非法的年龄";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
