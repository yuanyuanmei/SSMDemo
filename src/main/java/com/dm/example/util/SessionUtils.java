package com.dm.example.util;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.SysRoleBean;
import com.dm.example.beans.UserBaseBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class SessionUtils {

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
     * @param roleBeans
     */
    public static void setNavSession(List<SysRoleBean> roleBeans){
        getSession().setAttribute("nav",TreeUtils.convertToTree(getPermissionBeans(roleBeans),0));
    }

    /**
     * 通过session获得当前用户
     * @return
     */
    public static UserBaseBean getCurrentUser(){
        UserBaseBean bean = (UserBaseBean) getSession().getAttribute("user");
        return bean;
    }

    /**
     * 通过角色获取权限集合
     */
    public static List<SysPermissionBean> getPermissionBeans(List<SysRoleBean> roleBeans) {
        List<SysPermissionBean> permissionBeans = new ArrayList<>();
        for(int i =0;roleBeans!=null && i<roleBeans.size();i++){
            SysRoleBean roleBean = roleBeans.get(i);
            permissionBeans.addAll(roleBean.getPermissionBeans());
        }
        return permissionBeans;
    }



}
