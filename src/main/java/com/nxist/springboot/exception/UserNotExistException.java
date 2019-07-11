package com.nxist.springboot.exception;

/**
 * 自定义用户不存在异常
 * @Author: xym760
 * @Date: 2019/7/11 16:05
 * @Description:
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
