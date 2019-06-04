package com.dm.example.exception;

import com.dm.example.enums.EnumViewType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@Slf4j
public class CustomExceptionResolver implements HandlerExceptionResolver {

    /**
     * 系统抛出异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        CustomException customException = null;
        String errorMsg = "";

        //若该异常类型是系统自定义异常，则取出异常信息在错误页面即可
        if(e instanceof CustomException){
            customException = (CustomException) e;
            //获取错误信息
            errorMsg = customException.getMessage();
        }else{
            errorMsg = e.getMessage();
        }
        modelAndView.addObject("errorMsg",errorMsg);
        modelAndView.setViewName(EnumViewType.ERROR_500.getResponse());
        //日志记录
        log.error("{}",errorMsg);
        return modelAndView;
    }
}
