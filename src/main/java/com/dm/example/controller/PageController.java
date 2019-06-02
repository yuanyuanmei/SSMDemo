package com.dm.example.controller;

import com.dm.example.constants.ViewNameConsts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pageController
 * 一些页面的跳转
 */
@Controller
public class PageController {


    /**
     * 没有权限跳转600页面
     * @return
     */
    @GetMapping(ViewNameConsts.ERROR_600)
    public String ERROR_600(Model model){
        model.addAttribute("title","没有权限访问");
        return ViewNameConsts.ERROR_600;
    }
    /**
     * 报错跳转500页面
     * @return
     */
    @GetMapping(ViewNameConsts.ERROR_500)
    public String ERROR_500(Model model){
        model.addAttribute("title","页面出错啦");
        return ViewNameConsts.ERROR_500;
    }

    /**
     * 找不到页面
     * @return
     */
    @GetMapping(ViewNameConsts.ERROR_404)
    public String ERROR_404(Model model){
        model.addAttribute("title","找不到页面");
        return ViewNameConsts.ERROR_404;
    }


}
