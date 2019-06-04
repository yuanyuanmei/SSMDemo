package com.dm.example.controller;

import com.dm.example.annotations.ValidateCustom;
import com.dm.example.beans.UserAccountBean;
import com.dm.example.constants.ApiFuncConsts;
import com.dm.example.constants.ApiModuleConsts;
import com.dm.example.dto.ResultDto;
import com.dm.example.enums.EnumViewType;
import com.dm.example.exception.CustomException;
import com.dm.example.service.UserAccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 用户controller
 */
@Controller
@RequestMapping(ApiModuleConsts.USER)
public class UserAccountController {

    @Autowired
    private UserAccountService accountService;

    //访问登录页面
    @GetMapping(ApiFuncConsts.LOGIN)
    public String login(Model model){
        return EnumViewType.LOGIN.getResponse();
    }

    //登录验证
    @PostMapping(ApiFuncConsts.LOGIN)
    @ValidateCustom(value = UserAccountBean.class)
    public String login(UserAccountBean paramBean,Model model) throws CustomException {
        //1.帐号密码登录
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(paramBean.getAccount(),paramBean.getPassword(),"");
        try {
            //执行认证操作.
            subject.login(token);
            //设置过期时间
            subject.getSession().setTimeout(2*60*60*1000);
            return "redirect:"+EnumViewType.ADMIN_INDEX.getRequest();
        }catch (UnknownAccountException ua){
            model.addAttribute("errorMsg","帐号不存在");
        }catch (AuthenticationException ae) {
            model.addAttribute("errorMsg","帐号密码错误");
        }
        return EnumViewType.LOGIN.getResponse();
    }

    //访问注册页面
    @GetMapping(ApiFuncConsts.REIGISTER)
    public String register(Model model){
        return EnumViewType.REGISTER.getResponse();
    }

    //注册验证
    @PostMapping(ApiFuncConsts.REIGISTER)
    @ValidateCustom(value = UserAccountBean.class)
    public String register(UserAccountBean paramBean,Model model) {
        ResultDto resultDto = accountService.save(paramBean);
        if(resultDto.getCode().equals(400)){
            model.addAttribute("errorMsg",resultDto.getMessage());
            return EnumViewType.REGISTER.getResponse();
        }
        return "redirect:"+EnumViewType.LOGIN.getRequest();
    }

    //登出
    @GetMapping(ApiFuncConsts.LOGOUT)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:"+EnumViewType.LOGIN.getRequest();
    }

}
