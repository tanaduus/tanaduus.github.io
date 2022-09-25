package tanaduus.github.io;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Slf4j
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order = 50)
public class DubboServiceLogFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // 方法开始执行的时间
        long startTime = System.currentTimeMillis();
        // 全部请求参数
        Object[] objects = invocation.getArguments();
        // 请求参数，如果只有一个那就取出来toJSONString，如果为空或者有多个那就直接 toJSONString
        String paramJsonStr =
            null != objects && objects.length == 1 ? JSON.toJSONString(objects[0]) : JSON.toJSONString(objects);
        // 接口+方法 名称
        String classMethod = invoker.getInterface() + "." + invocation.getMethodName();
        // 区分是作为提供者的日志还是消费者的日志
        String action = RpcContext.getContext().isConsumerSide() ? "invoke" : "handle";
        // dubbo接口调用
        log.info("{} {} params = {}", action, classMethod, paramJsonStr);
        Result result = invoker.invoke(invocation);
        log.info("{} {} result = {}, costTime = {}ms, hasException = {}", action, classMethod,
            JSON.toJSONString(result.getValue()), System.currentTimeMillis() - startTime, result.hasException());
        return result;
    }
}
