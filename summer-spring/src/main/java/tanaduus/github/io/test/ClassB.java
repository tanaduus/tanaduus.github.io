package tanaduus.github.io.test;

import lombok.Data;

/**
 * @author 夏冬
 * @date 2021/6/7
 */
@Data
public class ClassB {
    private Integer age;
    private String name;
    private Inner inner;


    @Data
    public static class Inner{
        private Integer a;
        public Inner(Integer a){
            this.a = a;
        }
    }
}
