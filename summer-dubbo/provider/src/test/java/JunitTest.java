import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tanaduus.github.io.ISummerProvider;
import tanaduus.github.io.ProviderApplication;
import tanaduus.github.io.SummerReq;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
public class JunitTest {

    @DubboReference(version = "1.0", loadbalance = "roundrobin", cluster = ClusterRules.FAIL_FAST)
    private ISummerProvider iSummerProvider;

    @Test
    public void test() {
        SummerReq req = new SummerReq();
        req.setId(1);
//        req.setName("summer");

        System.out.println(iSummerProvider.call(req));
    }
}
