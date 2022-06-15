package tanaduus.github.io.reflect.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author 夏冬
 * @date 2022/6/9
 */
public class Test {

    public static void main(String[] args) throws Throwable {

//        invoke();
//
//        invokeExact();
//
//        invokeExactPublic();

        invokeBindTo();
    }

    private static void invoke() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType mt = MethodType.methodType(String.class, Integer.class);

        MethodHandle just = lookup.findVirtual(Test.class, "just", mt);

        System.out.println(just.invoke(new Test(), 2));
    }

    private static void invokeExact() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType mt = MethodType.methodType(String.class, Integer.class);

        MethodHandle just = lookup.findVirtual(Test.class, "just", mt);

        System.out.println((String) just.invokeExact(new Test(), (Integer)2));
    }

    private static void invokeExactPublic() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.publicLookup();

        MethodType mt = MethodType.methodType(String.class, Double.class);

        MethodHandle even = lookup.findVirtual(Test.class, "even", mt);

        System.out.println((String) even.invokeExact(new Test(), (Double)2d));
    }

    private static void invokeBindTo() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType mt = MethodType.methodType(String.class, Integer.class);

        MethodHandle just = lookup.findVirtual(Test.class, "just", mt);

        System.out.println(just.bindTo(new Test()).invoke(3));
    }

    private String just(Integer i) {
        return i+"s";
    }

    public String even(Double i) {
        return i+"s";
    }
}
