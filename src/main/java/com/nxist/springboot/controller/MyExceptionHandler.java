package com.nxist.springboot.controller;

import com.nxist.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器
 * 要成为异常处理器，就得用@ControllerAdvice注解
 * @Author: xym760
 * @Date: 2019/7/11 16:14
 * @Description:
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 只要出现UserNotExistException异常，SpringMVC就会调用这个方法，把异常对象传进来
     * 缺点：没有自适应性，浏览器和手机客户端等都是返回JSON数据
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user not exist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码：4xx,5xx
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user not exist");
        map.put("message", "用户出错啦");
        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
