package com.daily.mybatis.test;

import com.daily.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 11851 on 2017/8/13.
 */
public class MybatisTest {

    public static void main(String[] args) {
        System.out.println("....");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-core.xml");
        UserService userdao = (UserService) context.getBean("UserService");
    }

}
