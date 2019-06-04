package com.dm.example.enums;

import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum EnumViewType {

    //404页面
    ERROR_404(ApiModuleConsts.ERROR+ ApiFuncConsts.ERROR_404,"error/404","404"),

    //500页面
    ERROR_500(ApiModuleConsts.ERROR+ ApiFuncConsts.ERROR_500,"error/500","500"),

    //600页面
    ERROR_600(ApiModuleConsts.ERROR+ ApiFuncConsts.ERROR_600,"error/600","没有权限"),

    //登录页面
    LOGIN(ApiModuleConsts.USER+ ApiFuncConsts.LOGIN,"view/login","登录"),

    //注册
    REGISTER(ApiModuleConsts.USER+ ApiFuncConsts.REIGISTER,"view/register","注册"),

    //后台管理页面
    ADMIN_INDEX(ApiModuleConsts.ADMIN+ ApiFuncConsts.INDEX,"admin/index","后台管理"),

    //用户列表
    SYS_USER(ApiModuleConsts.SYS+ ApiFuncConsts.USER+ApiFuncConsts.LIST,"admin/index","用户管理"),

    //角色列表
    SYS_ROLE(ApiModuleConsts.SYS+ ApiFuncConsts.ROLE+ApiFuncConsts.LIST,"admin/index","角色管理"),

    //菜单列表
    SYS_MENU(ApiModuleConsts.SYS+ ApiFuncConsts.MENU+ApiFuncConsts.LIST,"admin/index","菜单管理"),

    //登出页面
    LOGOUT(ApiModuleConsts.USER+ ApiFuncConsts.LOGOUT,"view/login","登出");

    private String request;

    private String response;

    private String title;

    EnumViewType(String request,String response,String title){
        this.request = request;
        this.response = response;
        this.title = title;
    }

    public final String getRequest() {
        return request;
    }

    public final String getResponse() {
        return response;
    }

    public final String getTitle() {
        return title;
    }

    /**
     * 根据Key查找枚举
     * @param request
     * @return
     */
    public static EnumViewType RequestOf(String request){
        List<EnumViewType> collect = list.stream().filter(item -> item.request.equals(request)).collect(Collectors.toList());
        EnumViewType obj = collect.size() > 0 ? collect.get(0) : null;
        return obj;
    }
    //枚举的变量必须为static静态
    public static List<EnumViewType> list = Arrays.asList(values());

}