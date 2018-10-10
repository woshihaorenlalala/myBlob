package com.blob.module.sys.controller;

import com.blob.module.common.sys.entity.Constant;
import com.blob.module.common.sys.entity.HttpResult;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cc on 2018/10/9.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String index(){
        ModelAndView mv = new ModelAndView("index");
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String,Object> map){

        String exception = (String) request.getAttribute("shiroLoginFailure");

        String msg = "";
        if(null != exception) {
            if(UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            }else if(IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            }else if("kaptchaValidateFailed".equals(exception)){
                msg = "验证码错误";
            }else {
                msg = "else:" + exception;
            }
        }
        map.put("msg", msg);
        return "login";
    }
}
