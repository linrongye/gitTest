/*
package mapper.aop.aop;

import jdk.nashorn.internal.ir.JoinPredecessor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Component
@Aspect
public class LogAop {
    @Pointcut("execution(* mapper.aop.service..*.*(..))")
    public void pt(){
    }

    @Before("pt()")
    public  void log(*/
/*ProceedingJoinPoint joinPoint*//*
){
        try {
           */
/* joinPoint.proceed();*//*

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("正在打印日志");
    }
    @Around("pt()")
    public void logs(ProceedingJoinPoint join){
        System.out.println("环绕-----");
        try {
            Object proceed = join.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @AfterReturning(returning = "o",pointcut = "pt()")
    public int logs2(JoinPoint joinPoint,Object o){
        return 1;
    }
}
*/
