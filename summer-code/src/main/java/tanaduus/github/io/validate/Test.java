package tanaduus.github.io.validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;


public class Test {

    public static void main(String[] args) {

        StudentDO studentDO = new StudentDO();
        studentDO.setName("");
        studentDO.setAge(2000);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<StudentDO>> set = validator.validate(studentDO, Default.class);
        StringBuilder msg = new StringBuilder();
        set.forEach(entry -> msg.append(entry.getMessage()).append("<br>"));

        System.out.println(msg);
    }
}
