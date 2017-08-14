package com.daily.mybatis.test;

import com.daily.mybatis.dao.UserDao;
import com.daily.mybatis.entity.User;
import com.daily.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 11851 on 2017/8/13.
 */
public class MybatisTest {

    public static void main(String[] args) {
        System.out.println("....");
        ApplicationContext context = new ClassPathXmlApplicationContext("app-core.xml");
        UserService userdao = (UserService) context.getBean("UserService");
        List<User> all = userdao.findAll();
        for (User user : all) {

            System.out.println(user);
        }

    }

}
