package tanaduus.github.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@Slf4j
@DubboService(version = "1.0", validation = "true", cluster = ClusterRules.FAIL_FAST)
public class SummerProvider implements ISummerProvider, InitializingBean {

    @Override
    public BaseResult<SummerResp> call(BaseReq req) {

        RpcContext.getContext();

        return BaseResult.newSuccess(SummerResp.builder()
                .name("测试:" + Constant.UID)
                .amount(BigDecimal.valueOf(12))
                .extra("额外信息")
                .build());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SummerProvider loaded");
    }
}