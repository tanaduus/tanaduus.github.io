package tanaduus.github.io.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tanaduus.github.io.service.eventbus.EventBusCenter;
import tanaduus.github.io.service.eventbus.OrderChangeEvent;
import tanaduus.github.io.service.eventbus.OrderCreateEvent;

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
//        context.getBean("factoryBeanImpl", Car.class).dudu();
        EventBusCenter eventBusCenter = context.getBean("eventBusCenter", EventBusCenter.class);

        eventBusCenter.postSync(new OrderCreateEvent());
        eventBusCenter.postSync(new OrderChangeEvent());
    }
}
