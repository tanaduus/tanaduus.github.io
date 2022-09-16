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
public class ProviderApplication {

    public static void main(String[] args) throws Exception {

        Constant.UID = 1;

        SpringApplication.run(ProviderApplication.class, args);
        System.out.println("dubbo service started");
//        new CountDownLatch(1).await();
    }
}
