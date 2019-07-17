package com.nxist.springboot.config;

import com.nxist.springboot.filter.MyFilter;
import com.nxist.springboot.listener.MyListener;
import com.nxist.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * 配置服务器相关内容
 */
@Configuration
public class MyServerConfig {

    //注册三大组件
    //注册Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterFilterRegistrationBean = new FilterRegistrationBean();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        //设置拦截哪些请求
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterFilterRegistrationBean;
    }

    //注册Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }


    //配置嵌入式的Servlet容器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        //定制嵌入式的Servlet容器相关的规则
        return (ConfigurableWebServerFactory factory) -> {
//            factory.setPort(8083);//设置端口为8083
        };
    }
}
