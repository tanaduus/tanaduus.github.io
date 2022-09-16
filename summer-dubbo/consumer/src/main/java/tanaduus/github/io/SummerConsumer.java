package tanaduus.github.io;

import com.alibaba.fastjson.JSON;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@Service
public class SummerConsumer {

    @DubboReference(version = "1.0", loadbalance = "roundrobin", cluster = ClusterRules.FAIL_FAST)
    private ISummerProvider iSummerProvider;

    public SummerResp call() {

        SummerReq req = new SummerReq();
        req.setId(1);
//        req.setName("summer");

        BaseResult<SummerResp> result = iSummerProvider.call(req);
        System.out.println("##结果："+ JSON.toJSONString(result));
        return result.getData();
    }
}
