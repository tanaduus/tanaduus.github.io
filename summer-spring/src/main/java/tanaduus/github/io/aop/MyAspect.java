package tanaduus.github.io.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import tanaduus.github.io.annotation.MyAnnotation;

@Aspect
public class MyAspect {

    @Around(value = "@annotation(myAnnotation)")
    public Object around(ProceedingJoinPoint jp, MyAnnotation myAnnotation) throws Throwable {
        System.out.print(myAnnotation.value()+" ");

        for(Object o : jp.getArgs()){
            System.out.print(o+",");
        }

        return jp.proceed();
    }
}
