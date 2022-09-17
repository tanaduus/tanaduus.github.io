import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.junit.Test;
import tanaduus.github.io.ISummerProvider;
import tanaduus.github.io.SummerReq;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author 夏加龙
 * @date 2022/9/17
 */
public class GenericDubboTest {


    /**
     * 通过API方式使用泛化调用
     */
    @Test
    public void test() {

        // 应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("test-consumer");

        // 注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        // 引用远程服务
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setGeneric("true");
        reference.setInterface("tanaduus.github.io.ISummerProvider");
        reference.setVersion("1.0");
        reference.setUrl("dubbo://127.0.0.1:20880/tanaduus.github.io.ISummerProvider");

        // 获取GenericService，代替
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);

        // 调用服务
        String[] parameterTypes = new String[]{"tanaduus.github.io.BaseReq"};

        SummerReq req = new SummerReq();
        req.setId(1);
        req.setName("summer");

        Object[] args = Stream.of(req).toArray();
        Object result = genericService.$invoke("call", parameterTypes, args);
        System.out.println("result = " + result);
    }
}