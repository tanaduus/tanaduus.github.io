package tanaduus.github.io.reflect.method;

import java.lang.reflect.Method;

public class test {

    public static void main(String[] args) {

        Class clazz = TestMethodImpl.class;

//        Method[] methods = clazz.getMethods();
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method:methods){
            System.out.println("************************************");
            System.out.println(method.isBridge());
            System.out.println(method.getName());
            System.out.println(method.getParameterTypes()[0].getName());
            System.out.println(method.getReturnType().getName());
            System.out.println(method.getGenericParameterTypes()[0].getTypeName());
            System.out.println(method.getGenericReturnType().getTypeName());
        }

//        System.out.println("*********");
//
//        Class clazz2 = TestMethodImpl2.class;
//
//        Method[] methods2 = clazz2.getDeclaredMethods();
//
//        for(Method method:methods2){
//
//            System.out.println(method.getParameterTypes()[0].getName());
//            System.out.println(method.getReturnType().getName());
//        }
    }
}
