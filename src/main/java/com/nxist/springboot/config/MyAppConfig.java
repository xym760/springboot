package com.nxist.springboot.config;

import com.nxist.springboot.services.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是一个配置类；就是来替代之前的Springp配置文件
 * 以前在配置文件中用bean标签来添加组件
* @Author: xym760
 * @Date: 2019/7/2 11:52
 * @Description:
 */
@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService02(){
        System.out.println("配置类@Bean给容器中添加组件了。。。");
        return new HelloService();
    }
}
