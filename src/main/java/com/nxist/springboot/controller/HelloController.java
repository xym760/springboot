package com.nxist.springboot.controller;

import com.nxist.springboot.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }

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
