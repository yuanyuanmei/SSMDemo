package com.dm.example.aop;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.SysRoleBean;
import com.dm.example.beans.UserBaseBean;
import com.dm.example.dao.SysPermissionDao;
import com.dm.example.enums.EnumViewType;
import com.dm.example.service.SysPermissionService;
import com.dm.example.util.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class ControllerInterceptor {

    @Autowired
    private SysPermissionService permsService;

    @Pointcut("execution(* com.dm.example.controller..*(..))")
    private void pointcut(){}

    @Before(value = "pointcut()")
    public void before(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        EnumViewType enumObj = EnumViewType.RequestOf(request.getServletPath());
        //根据路径查出角色对象
        SysPermissionBean permsBean = permsService.getPermsBeanByUrl(request.getServletPath());
        //获取session中用户对象
        UserBaseBean user = SessionUtils.getCurrentUser();
        //初始化面包屑
        List<SysPermissionBean> breadCrumbs = new ArrayList<>();
        if(Objects.nonNull(user)){
            //设置面包屑
            breadCrumbs = permsService.breadCrumbs(breadCrumbs,SessionUtils.getPermissionBeans(user.getRoleBeans()),permsBean);
        }

        //设置操作类型
        String opt = request.getParameter("opt") == null ? "list" : request.getParameter("opt");
        request.setAttribute("opt",opt);
        request.setAttribute("breadCrumbs",breadCrumbs);
        request.setAttribute("url",request.getServletPath());
        request.setAttribute("title",enumObj.getTitle());
    }

}
