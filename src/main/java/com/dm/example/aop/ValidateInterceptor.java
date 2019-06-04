package com.dm.example.aop;

import com.dm.example.annotations.ValidateCustom;
import com.dm.example.enums.EnumViewType;
import com.dm.example.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
/**
 * 拦截自定义验证注解
 */
public class ValidateInterceptor {

    // annotation表达式寻找自定义注解的位置
    @Around(value = "@annotation(com.dm.example.annotations.ValidateCustom)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取代理方法
        Method proxyMethod = ((MethodSignature)joinPoint.getSignature()).getMethod();
        try {
            // 通过代理方法获取目标方法
            Method targetMethod = joinPoint.getTarget().getClass().getMethod(proxyMethod.getName(),proxyMethod.getParameterTypes());
            // 通过目标方法获取自定义注解
            ValidateCustom custom = targetMethod.getAnnotation(ValidateCustom.class);
            // 获得注解中需要校验参数类
            //常规方法获取参数
//            Object obj = null;
//            for(int i = 0;i<joinPoint.getArgs().length;i++){
//                if(custom.value().equals(joinPoint.getArgs()[i].getClass())){
//                    obj = joinPoint.getArgs()[i];
//                    break;
//                }
//            }
            //jdk8新特性filter过滤属性+三元运算符
            List<Object> objects = Arrays.stream(joinPoint.getArgs())
                    .filter(Object -> Object.getClass().equals(custom.value()))
                    .collect(Collectors.toList());
            Object obj = objects.size() > 0 ? objects.get(0) : null;

            // 参数校验
            String validateMsg =  ValidationUtils.validate(obj);
            if(Objects.nonNull(validateMsg)){
                // 获取request对象，传递参数
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                request.setAttribute("errorMsg",validateMsg);
                return EnumViewType.RequestOf(request.getServletPath()).getResponse();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            log.error("{}",e.getMessage());
        }
        return joinPoint.proceed();
    }
}
