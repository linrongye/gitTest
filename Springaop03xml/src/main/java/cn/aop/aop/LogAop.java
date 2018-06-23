package cn.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
    public  void log(ProceedingJoinPoint joinPoint){
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("正在打印日志");
    }
}
