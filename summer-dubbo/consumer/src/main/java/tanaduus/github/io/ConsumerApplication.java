package tanaduus.github.io;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@SpringBootApplication
@EnableDubbo
public class ConsumerApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(ConsumerApplication.class, args);
        System.out.println("dubbo service started");
    }
}
