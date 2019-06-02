package com.dm.example.util;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.UserBaseBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

public class UserUtils {

    /**
     * 获得shiro自带session
     * @return
     */
    public static Session getSession(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return session;
    }

    /**
     * 设置userSession
     * @param bean
     */
    public static void setUserSession(UserBaseBean bean){
        getSession().setAttribute("user",bean);
    }

    /**
     * 设置菜单session
     * @param list
     */
    public static void setNavSession(List<SysPermissionBean> list){
        getSession().setAttribute("nav",TreeUtils.convertToTree(list,0));
    }
    /**
     * 通过session获得当前用户
     * @return
     */
    public static UserBaseBean getCurrentUser(){
        UserBaseBean bean = (UserBaseBean) getSession().getAttribute("user");
        return bean;
    }



}
