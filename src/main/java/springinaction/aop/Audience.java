package springinaction.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* springinaction.aop.PerformanceImpl.perform(..))")
    public void perform() {

    }
    @Before ("perform()")
    public void silenceCellPhones() {
        System.out.println ("silencing cell phones");

    }


    @AfterReturning("perform()")
    public void applause() {
        System.out.println ("clap clap clap");
    }


    @Around ("perform()")
    public void watchPerformance() {

    }
}
