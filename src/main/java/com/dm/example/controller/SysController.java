package com.dm.example.controller;

import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.constants.ViewNameConsts;
import com.dm.example.dto.PageDto;
import com.dm.example.service.UserBaseService;
import org.apache.shiro.session.Session;
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

    //用户列表
    @GetMapping(ApiFuncConsts.USER)
    public String getUserList(PageDto pageDto,Model model){
        model.addAttribute("title","用户列表");
        model.addAttribute("sysType","user");
        model.addAttribute("pageList",baseService.pageList(pageDto));
        return ViewNameConsts.ADMIN_VIEW;
    }
    //角色列表
    @GetMapping(ApiFuncConsts.ROLE)
    public String getRoleList(Model model){
        model.addAttribute("title","权限列表");
        model.addAttribute("sysType","role");
        return ViewNameConsts.ADMIN_VIEW;
    }
    //权限列表
    @GetMapping(ApiFuncConsts.MENU)
    public String getMenuList(Model model){
        model.addAttribute("title","菜单列表");
        model.addAttribute("sysType","menu");
        return ViewNameConsts.ADMIN_VIEW;
    }
}
