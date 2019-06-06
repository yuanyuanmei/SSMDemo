package com.dm.example.aop;

import com.dm.example.annotations.CrudCustom;
import com.dm.example.base.BaseEntity;
import com.dm.example.base.BaseService;
import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.UserBaseBean;
import com.dm.example.dto.PageDto;
import com.dm.example.enums.EnumViewType;
import com.dm.example.service.SysPermissionService;
import com.dm.example.util.SessionUtils;
import com.dm.example.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class CrudInterceptor {

    @Autowired
    private SysPermissionService permsService;


    @Before(value = "@annotation(com.dm.example.annotations.CrudCustom)")
    public void before(JoinPoint joinPoint) {
        // 获取代理方法
        Method proxyMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();

        // 通过代理方法获取目标方法
        Method targetMethod = null;
        try {
            targetMethod = joinPoint.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //1.获取面包屑
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        EnumViewType enumObj = EnumViewType.RequestOf(request.getServletPath());
        //根据路径查出角色对象
        SysPermissionBean permsBean = permsService.getPermsBeanByUrl(request.getServletPath());
        //获取session中用户对象
        UserBaseBean user = SessionUtils.getCurrentUser();
        //初始化面包屑
        List<SysPermissionBean> breadCrumbs = new ArrayList<>();
        if (Objects.nonNull(user)) {
            //设置面包屑
            breadCrumbs = permsService.breadCrumbs(breadCrumbs, SessionUtils.getPermissionBeans(user.getRoleBeans()), permsBean);
        }

        //2.CRUD操作
        // 通过目标方法获取自定义注解
        CrudCustom crudCustom = targetMethod.getAnnotation(CrudCustom.class);

        //通过注解参数获得目标对象
        BaseService baseService = (BaseService) SpringContextUtil.getApplicationContext().getBean(crudCustom.value());
        //获得请求类型
        String methodType = request.getMethod();

        //设置操作类型
        String opt = request.getParameter("opt") == null ? "list" : request.getParameter("opt");
        if(methodType.equals("GET")){

            switch (opt){
                case "list":
                    Integer pageNum =  Objects.isNull(request.getParameter("pageNum")) ? 1 : Integer.valueOf(request.getParameter("pageNum"));
                    Integer pageSize =  Objects.isNull(request.getParameter("pageSize")) ? 10 : Integer.valueOf(request.getParameter("pageSize"));
                    request.setAttribute("pageList",baseService.pageList(new PageDto(pageNum,pageSize)));
                    break;
                case "update":
                    Long id = Long.valueOf(request.getParameter("id"));
                    request.setAttribute("item",baseService.selectByPrimaryKey(id));
                    break;
            }

        }else{
            BaseEntity bean = (BaseEntity) joinPoint.getArgs()[0];
            UserBaseBean baseBean = (UserBaseBean) joinPoint.getArgs()[0];
            System.out.println(baseBean.toString());
            if(Objects.isNull(bean.getId())){
                baseService.insert(joinPoint.getArgs()[0]);
            }else{
                baseService.update(joinPoint.getArgs()[0]);
            }
        }

        request.setAttribute("opt", opt);
        request.setAttribute("breadCrumbs", breadCrumbs);
        request.setAttribute("url", request.getServletPath());
        request.setAttribute("title", enumObj.getTitle());

    }

}
