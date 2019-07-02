package com.nxist.springboot;

import com.nxist.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * spring boot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    Person person;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testHelloService(){
        boolean helloService = applicationContext.containsBean("helloService02");
        System.out.println(helloService);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
