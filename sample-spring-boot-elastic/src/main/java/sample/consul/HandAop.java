package sample.consul;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HandAop {

    @Pointcut(value = "@annotation(sample.consul.Hand)")
    public void hand() {
        System.out.println("point");
    }

    @Before("hand()")
    public void aroundAdvice(JoinPoint joinPoint) throws Throwable {
        Object returnVale = joinPoint.getArgs()[0];
        Student student = (Student) returnVale;
        student.setName(student.getName() + "999");
    }

}
