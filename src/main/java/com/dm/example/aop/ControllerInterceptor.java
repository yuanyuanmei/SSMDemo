package com.dm.example.aop;

import com.dm.example.enums.EnumViewType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerInterceptor {

    @Pointcut("execution(* com.dm.example.controller..*(..))")
    private void pointcut(){}

    @Before(value = "pointcut()")
    public void before(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        EnumViewType enumObj = EnumViewType.RequestOf(request.getServletPath());
        request.setAttribute("title",enumObj.getTitle());
    }

}
