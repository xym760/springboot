package com.nxist.springboot.config;

import com.nxist.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurer可以来扩展SpringMVC的功能
 *
 * @Author: xym760
 * @Date: 2019/7/8 15:02
 * @Description:
 */
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /nxist请求来到success页面
        registry.addViewController("/nxist").setViewName("success");
    }

    /**
     * 所有的WebMvcConfigurer组件都会一起起作用
     * 使用@Bean注解将组件注册到容器中
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");//添加视图映射，当访问/main.html，来到dashboard视图
            }
        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
