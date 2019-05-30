package com.dm.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 异常信息日志处理
 */
@Slf4j
@Aspect
@Component
public class LogInterceptor {

    //环绕通知 必须返回Object,不然后面的方法不会执行！！！！！
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{

        //获取类名和方法名
        Object result = null;
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        long startTime = System.currentTimeMillis();
        try{
            result =  joinPoint.proceed();

        }catch (Throwable e){
            StackTraceElement stackTraceElement= e.getStackTrace()[e.getStackTrace().length-1];

            Object[] args=joinPoint.getArgs();
            log.error("----------------------------------------------------------------------------------");
            log.error ( "===执行{}类的{}()方法的{}行",className,methodName,stackTraceElement.getLineNumber());
            log.error("===异常信息为：{}  ",e.fillInStackTrace().toString());
            log.error("===参数信息为：{}  ",args);
            throw e;
        }finally {
            long endTime = System.currentTimeMillis();
            log.info("{}",className+"类的"+methodName+"方法运行时间为"+(endTime-startTime)/1000+"s");
        }

        return result;

    }
















}
