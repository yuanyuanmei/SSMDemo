package com.dm.example.controller;

import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.constants.ViewNameConsts;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(ApiModuleConsts.ADMIN)
public class AdminController {

    //访问登录页面
    @GetMapping(ApiFuncConsts.INDEX)
    public String login(Model model){
        model.addAttribute("title","后台管理系统");
        return ViewNameConsts.ADMIN_VIEW;
    }
}
