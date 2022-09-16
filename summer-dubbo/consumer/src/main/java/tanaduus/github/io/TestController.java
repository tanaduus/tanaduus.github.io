package tanaduus.github.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@RestController
public class TestController {

    @Autowired
    private SummerConsumer summerConsumer;

    @RequestMapping("/call")
    public SummerResp call() {

        return summerConsumer.call();
    }
}
