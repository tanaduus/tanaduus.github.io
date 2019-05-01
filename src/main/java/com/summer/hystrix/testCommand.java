package com.summer.hystrix;

import com.netflix.hystrix.*;

import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class testCommand extends HystrixCommand<String> {

    @Override
    protected String run() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "call";
    }

    @Override
    protected String getFallback() {
        return "fallback";
    }

    public testCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(5000)
                )
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                //配置队列大小
                                .withMaxQueueSize(10)
                                // 配置线程池里的线程数
                                .withCoreSize(2)
                )
        );
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Stack<Future<String>> stack = new Stack<>();
        for (int i = 0; i < 20; i++) {
            Future<String> future = new testCommand("test-key").queue();
            stack.push(future);
        }

        while (!stack.empty()) {
            Future<String> future = stack.pop();
            System.out.println(future.get());
        }

    }
}
