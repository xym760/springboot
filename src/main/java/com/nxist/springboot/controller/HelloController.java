package com.nxist.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xym760
 * @Date: 2019/7/1 11:48
 * @Description:
 */
//@ResponseBody//将数据直接返回给浏览器
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World quick!";
    }
}
