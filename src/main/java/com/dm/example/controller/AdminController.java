package com.dm.example.controller;

import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.enums.EnumViewType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiModuleConsts.ADMIN)
public class AdminController {

    //访问登录页面
    @GetMapping(ApiFuncConsts.INDEX)
    public String login(Model model){
        return EnumViewType.ADMIN_INDEX.getResponse();
    }

}
