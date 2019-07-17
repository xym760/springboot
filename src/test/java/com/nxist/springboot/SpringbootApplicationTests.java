package com.nxist.springboot;

import com.nxist.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * spring boot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    //注入数据源
    @Autowired
    DataSource dataSource;

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
    public void contextLoads() throws SQLException {
        //查看数据源的输出：
        System.out.println("---------"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("---------"+connection);
        connection.close();
//        System.out.println(person);
        //日志的级别
        //由低到高：trace<debug<info<warn<error
        //可以调整输出的日志级别，然后日志就会这这个级别集以上的级别生效
        logger.trace("这是trace日志。。。");
        logger.debug("这是debug日志。。。");
        //spring默认给我们使用的是info级别的,没有指定级别，就用spring boot的默认级别；root级别
        logger.info("这是info日志。。。");
        logger.warn("这是warn日志。。。");
        logger.error("这是error日志。。。");
    }

}
