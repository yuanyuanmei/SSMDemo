package com.dm.example.controller;

import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.dto.PageDto;
import com.dm.example.enums.EnumViewType;
import com.dm.example.service.SysPermissionService;
import com.dm.example.service.SysRoleService;
import com.dm.example.service.UserBaseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限列表管理
 */
@Controller
@RequestMapping(ApiModuleConsts.SYS)
public class SysController {

    @Autowired
    private UserBaseService baseService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysPermissionService permsService;

    //用户列表
    @GetMapping(ApiFuncConsts.USER)
    public String getUserList(PageDto pageDto, HttpServletRequest request){
        if(request.getAttribute("opt").equals(ApiFuncConsts.LIST)){
            request.setAttribute("pageList",baseService.pageList(pageDto));
        }else{

        }
        return EnumViewType.SYS_USER.getResponse();

    }
    //角色列表
    @GetMapping(ApiFuncConsts.ROLE)
    public String getRoleList(PageDto pageDto,HttpServletRequest request){
        if(request.getAttribute("opt").equals(ApiFuncConsts.LIST)){
            request.setAttribute("pageList",roleService.pageList(pageDto));
        }else{

        }
        return EnumViewType.SYS_ROLE.getResponse();
    }
    //权限列表
    @GetMapping(ApiFuncConsts.MENU)
    public String getMenuList(PageDto pageDto,HttpServletRequest request){
        if(request.getAttribute("opt").equals(ApiFuncConsts.LIST)){
            request.setAttribute("pageList",permsService.pageList(pageDto));
        }else{

        }
        return EnumViewType.SYS_MENU.getResponse();
    }

}
