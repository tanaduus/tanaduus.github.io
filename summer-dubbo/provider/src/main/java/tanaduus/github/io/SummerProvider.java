package tanaduus.github.io;

import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboService;

import java.math.BigDecimal;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@DubboService(version = "1.0", validation = "true", cluster = ClusterRules.FAIL_FAST)
public class SummerProvider implements ISummerProvider {

    @Override
    public BaseResult<SummerResp> call(BaseReq req) {
        return BaseResult.newSuccess(SummerResp.builder()
                .name("测试:" + Constant.UID)
                .amount(BigDecimal.valueOf(12))
                .extra("额外信息")
                .build());
    }
}