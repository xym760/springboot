package com.nxist.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @Author: xym760
 * @Date: 2019/7/18 14:36
 * @Description:
 */
@org.springframework.context.annotation.Configuration//由于Mybatis的Configuration已经导入进来了，这里只能用全类名
public class MyBatisConfig {

    /**
     * 在容器中加入ConfigurationCustomizer，替换默认的配置，自己写配置
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
                //开启驼峰命名法
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
