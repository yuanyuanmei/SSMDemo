package com.dm.example.controller;

import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.enums.EnumViewType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pageController
 * 一些页面的跳转
 */
@Controller
@RequestMapping(ApiModuleConsts.ERROR)
public class ErrorController {

    /**
     * 没有权限
     * @return
     */
    @GetMapping(ApiFuncConsts.ERROR_600)
    public String ERROR_600(Model model){
        return EnumViewType.ERROR_600.getResponse();
    }
    /**
     * 500
     * @return
     */
    @GetMapping(ApiFuncConsts.ERROR_500)
    public String ERROR_500(Model model){
        return EnumViewType.ERROR_500.getResponse();
    }

    /**
     * 404
     * @return
     */
    @GetMapping(ApiFuncConsts.ERROR_404)
    public String ERROR_404(Model model){
        return EnumViewType.ERROR_404.getResponse();
    }


}
