package tanaduus.github.io.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class StudentProxy {

    public static void main(String[] args) {
        Person zhansan = new Student("张三");

        InvocationHandler stuHandler = new StudentInvocationHandler<Person>(zhansan);

        Person zhansanProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},stuHandler);

        zhansanProxy.giveMoney();
    }
}
