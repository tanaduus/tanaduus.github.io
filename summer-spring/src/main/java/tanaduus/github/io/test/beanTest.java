package tanaduus.github.io.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tanaduus.github.io.service.depend.Student;
import tanaduus.github.io.service.single.IPerson;
import tanaduus.github.io.service.single.Person;

public class beanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        IPerson person = context.getBean("person", IPerson.class);
        person.desc("夏");
        person.desc2();

//        Student student = context.getBean("student", Student.class);
//        student.learn();
    }
}
