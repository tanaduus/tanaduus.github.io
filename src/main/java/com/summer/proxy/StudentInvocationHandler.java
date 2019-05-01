package com.summer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentInvocationHandler<Person> implements InvocationHandler {

    Person target;

    public StudentInvocationHandler(Person target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理"+method.getName()+"方法");
        return method.invoke(target,args);
    }
}
