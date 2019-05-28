package com.dm.example.controller;

import com.dm.example.beans.UserAccountBean;
import com.dm.example.constants.ApiMethod;
import com.dm.example.constants.ApiModule;
import com.dm.example.dto.ResultDto;
import com.dm.example.exception.CustomException;
import com.dm.example.service.UserAccountService;
import com.dm.example.util.ValidationUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 用户controller
 */
@Controller
@RequestMapping(ApiModule.ADMIN)
public class UserAccountController {

    @Autowired
    private UserAccountService accountService;

    //访问登录页面
    @RequestMapping(value = ApiMethod.LOGIN,method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title","登录");
        return "view/login";
    }

    //登录校验
    @RequestMapping(value = ApiMethod.LOGIN,method = RequestMethod.POST)
    public String login(@RequestParam("username") String username
                            ,@RequestParam("password") String password
                            ,String rememberMe, HttpSession session,Model model) throws CustomException {
        //1.参数校验
        UserAccountBean paramBean = new UserAccountBean(username,password);
        String validateMsg =  ValidationUtils.validate(paramBean);
        if(Objects.nonNull(validateMsg)){
            model.addAttribute("errorMsg",validateMsg);
            return "view/login";
        }

        //2.登录校验
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        try {
            //执行认证操作.
            subject.login(token);
        }catch (AuthenticationException ae) {
            model.addAttribute("errorMsg","帐号密码错误");
            return "view/login";
        }
        return "/index";
    }

    @RequestMapping(value = ApiMethod.REIGISTER,method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("title","注册");
        return "view/register";
    }

    @RequestMapping(value = ApiMethod.REIGISTER,method = RequestMethod.POST)
    public String register(UserAccountBean paramBean,Model model) {
        //1.参数校验
        String validateMsg = ValidationUtils.validate(paramBean);
        if(Objects.nonNull(validateMsg)){
            model.addAttribute("errorMsg",validateMsg);
            return "view/register";
        }
        ResultDto resultUtil = accountService.save(paramBean);
        if(resultUtil.getCode().equals(400)){
            model.addAttribute("errorMsg",resultUtil.getMessage());
            return "view/register";
        }
        return "redirect:view/login";
    }
}
