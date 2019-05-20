package tanaduus.github.io.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tanaduus.github.io.service.depend.Student;
import tanaduus.github.io.service.factorybean.Car;
import tanaduus.github.io.service.single.IPerson;
import tanaduus.github.io.service.single.Person;

@Slf4j
public class beanTest {

    public static void main(String[] args) {
        ///输出动态代理生成的class文件
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        log.info(">>>>>> spring context start ... ...");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        log.info(">>>>>> spring context started");
//        IPerson person = context.getBean("person", IPerson.class);
//        person.desc("夏");
//        person.desc2();
//        Student student = context.getBean("student", Student.class);
//        student.learn();
        context.getBean("factoryBeanImpl", Car.class).dudu();
    }
}
