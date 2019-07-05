package tanaduus.github.io.validate;

import lombok.Data;

@Data
public class StudentDO {

    @IsName
    private String name;

    @IsAge
    private Integer age;

}
