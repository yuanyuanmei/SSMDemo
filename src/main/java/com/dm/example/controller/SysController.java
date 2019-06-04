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
    @GetMapping(ApiFuncConsts.USER+ApiFuncConsts.LIST)
    public String getUserList(PageDto pageDto,Model model){
        model.addAttribute("sysType","user");
        model.addAttribute("pageList",baseService.pageList(pageDto));
        return EnumViewType.SYS_USER.getResponse();
    }
    //角色列表
    @GetMapping(ApiFuncConsts.ROLE+ApiFuncConsts.LIST)
    public String getRoleList(PageDto pageDto,Model model){
        model.addAttribute("sysType","role");
        model.addAttribute("pageList",roleService.pageList(pageDto));
        return EnumViewType.SYS_ROLE.getResponse();
    }
    //权限列表
    @GetMapping(ApiFuncConsts.MENU+ApiFuncConsts.LIST)
    public String getMenuList(PageDto pageDto,Model model){
        model.addAttribute("sysType","menu");
        model.addAttribute("pageList",permsService.pageList(pageDto));
        return EnumViewType.SYS_MENU.getResponse();
    }
}
