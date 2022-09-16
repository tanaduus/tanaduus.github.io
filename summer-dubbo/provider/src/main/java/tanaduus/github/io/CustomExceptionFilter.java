package tanaduus.github.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

import javax.validation.ValidationException;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;
import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;


@Slf4j
@Activate(group = {CONSUMER, PROVIDER}, order = 100)
public class CustomExceptionFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // 获取rpcResult
        Result result = invoker.invoke(invocation);
        //发生异常
        if (result.hasException() && invoker.getInterface() != GenericService.class) {
            // 获取抛出的异常
            Throwable exception = result.getException();
//            System.out.println("###异常信息: " + exception.getMessage());
            //如果是自定义的异常，则返回异常code和message
            if (exception instanceof ValidationException) {
                return AsyncRpcResult.newDefaultAsyncResult(
                        BaseResult.newFailure(4001, exception.getMessage()),
                        invocation);
            } else {
                return AsyncRpcResult.newDefaultAsyncResult(
                        BaseResult.newFailure(5001, "unknown"),
                        invocation);
            }
        }

        return result;
    }

}
