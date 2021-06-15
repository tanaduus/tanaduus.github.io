package tanaduus.github.io.test;

import org.springframework.beans.BeanUtils;

/**
 * @author 夏冬
 * @date 2021/6/7
 */
public class BeanCopyTest {

    public static void main(String[] args) {

        ClassA a = new ClassA();
        a.setAge(1);
        a.setName("hehe");
        a.setInner(new ClassA.Inner(1));

        ClassB b = new ClassB();

        BeanUtils.copyProperties(a,b);
        System.out.println(a);
        System.out.println(b);
    }
}
