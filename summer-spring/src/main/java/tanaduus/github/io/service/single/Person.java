package tanaduus.github.io.service.single;

import tanaduus.github.io.aop.MyAnnotation;

public class Person implements IPerson{

    @Override
    @MyAnnotation("hello")
    public void desc(String name){
        System.out.println("i am a Person");
    }

    @Override
    public void desc2() {
        System.out.println("i am a Person too");
    }
}
