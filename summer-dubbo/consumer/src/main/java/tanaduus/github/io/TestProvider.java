package tanaduus.github.io;

import org.apache.dubbo.config.annotation.DubboService;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@DubboService(version = "1.0")
public class TestProvider implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "callable";
    }
}