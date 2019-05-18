package tanaduus.github.io.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.util.Set;
import java.util.function.BiConsumer;

public class InnerReflect {

    InnerReflect(){}

    public static void main(String args[]) throws Exception {
        Set<Class<?>> classSet = ClassTool.getClasses("tanaduus.github.io.reflect");

        InnerReflect targetOutObject = new InnerReflect();
        Class<?> outClazz = targetOutObject.getClass();

        System.out.println(BiConsumer.class.isAssignableFrom(outClazz));

        //匿名内部类的反射实例化
        Class innerObjectClass = Class.forName("tanaduus.github.io.reflect.InnerReflect$1");
        if (innerObjectClass.isAnonymousClass()) {
            Constructor<?> outObjectConstructor = innerObjectClass.getDeclaredConstructor(outClazz);
            outObjectConstructor.setAccessible(true);
            BiConsumer needOutObject = (BiConsumer) outObjectConstructor.newInstance(targetOutObject);
            needOutObject.accept("a","b");
        }
    }

    public void test() {
        BiConsumer<String, String> consumer = new BiConsumer<String, String>() {

            @Override
            @myAnnotation("haha")
            public void accept(String s, String s2) {
                System.out.println(s + s2);
            }
        };
    }

    @Target(ElementType.METHOD)
    public @interface myAnnotation{
        String value() default "";
    }
}
