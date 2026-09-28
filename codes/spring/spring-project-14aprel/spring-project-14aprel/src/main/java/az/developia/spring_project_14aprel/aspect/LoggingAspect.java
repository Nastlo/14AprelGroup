package az.developia.spring_project_14aprel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* az.developia.spring_project_14aprel.service.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {

        System.out.println("1. @Before -> "
                + joinPoint.getSignature().getName());
    }

    @Around("execution(* az.developia.spring_project_14aprel.service.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("2. @Around -> METODDAN EVVEL: "
                + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        System.out.println("3. @Around -> METODDAN SONRA: "
                + joinPoint.getSignature().getName());

        return result;
    }

    @AfterReturning(
            pointcut = "execution(* az.developia.spring_project_14aprel.service.*.*(..))",
            returning = "result"
    )
    public void afterReturningAdvice(
            JoinPoint joinPoint,
            Object result) {

        System.out.println("4. @AfterReturning -> "
                + joinPoint.getSignature().getName()
                + " | nəticə: " + result);
    }

    @After("execution(* az.developia.spring_project_14aprel.service.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {

        System.out.println("5. @After -> "
                + joinPoint.getSignature().getName());
    }

    @AfterThrowing(
            pointcut = "execution(* az.developia.spring_project_14aprel.service.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowingAdvice(
            JoinPoint joinPoint,
            Throwable exception) {

        System.out.println("X. @AfterThrowing -> "
                + joinPoint.getSignature().getName()
                + " | xəta: " + exception.getMessage());
    }
}