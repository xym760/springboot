package com.nxist.springboot.controller;

import com.nxist.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: xym760
 * @Date: 2019/7/1 11:48
 * @Description:
 */
//@ResponseBody//将数据直接返回给浏览器
@Controller
//@RestController
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World quick!";
    }

    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello", "<h1>你好！</h1>");
        map.put("users", Arrays.asList("zhangshan", "lisi", "wangwu"));
        return "success";
    }
}
