package com.nxist.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: xym760
 * @Date: 2019/7/8 17:31
 * @Description:
 */
@Controller
public class LoginController {

    //    @DeleteMapping
//    @PutMapping
//    @GetMapping
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
