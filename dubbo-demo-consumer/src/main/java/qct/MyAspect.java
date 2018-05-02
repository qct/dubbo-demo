package qct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <p>Created by Damon.Q on 2017/4/18.
 */
@Aspect
@Component
public class MyAspect {

    @Around("execution(* qct.DemoService+.say*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("after call");
    }

    private void before() {
        System.out.println("before call");
    }
}
