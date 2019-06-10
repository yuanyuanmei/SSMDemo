package com.dm.example.controller;

import com.dm.example.annotations.CrudCustom;
import com.dm.example.annotations.ValidateCustom;
import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.SysRoleBean;
import com.dm.example.beans.UserBaseBean;
import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.dto.PageDto;
import com.dm.example.enums.EnumUserType;
import com.dm.example.enums.EnumViewType;
import com.dm.example.service.SysPermissionService;
import com.dm.example.service.SysRoleService;
import com.dm.example.service.UserBaseService;
import com.dm.example.util.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @CrudCustom(UserBaseService.class)
    @GetMapping(ApiFuncConsts.USER)
    public String getUser(HttpServletRequest request){
        request.setAttribute("typeEnum", EnumUserType.list);
        return EnumViewType.SYS_USER.getResponse();
    }
    //角色列表
    @CrudCustom(SysRoleService.class)
    @GetMapping(ApiFuncConsts.ROLE)
    public String getRole(){
        return EnumViewType.SYS_ROLE.getResponse();
    }
    //权限列表
    @CrudCustom(SysPermissionService.class)
    @GetMapping(ApiFuncConsts.MENU)
    public String getMenu(){
        return EnumViewType.SYS_MENU.getResponse();
    }

    //用户修改或新增
    @ResponseBody
    @ValidateCustom(UserBaseBean.class)
    @CrudCustom(UserBaseService.class)
    @PostMapping(ApiFuncConsts.USER)
    public String saveUser(UserBaseBean paramBean){
        return StringUtils.formatSuccessJson("更新成功");
    }

    //用户修改或新增
    @ResponseBody
    @ValidateCustom(SysRoleBean.class)
    @CrudCustom(SysRoleService.class)
    @PostMapping(ApiFuncConsts.ROLE)
    public String saveRole(SysRoleBean paramBean){
        return StringUtils.formatSuccessJson("更新成功");
    }

    //用户修改或新增
    @ResponseBody
    @ValidateCustom(SysPermissionBean.class)
    @CrudCustom(SysPermissionService.class)
    @PostMapping(ApiFuncConsts.MENU)
    public String saveMenu(SysPermissionBean paramBean){
        return StringUtils.formatSuccessJson("更新成功");
    }
}
