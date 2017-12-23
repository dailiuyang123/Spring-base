package com.daily.web.service;

import com.daily.mybatis.dao.UserDao;
import com.daily.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 11851 on 2017/8/13.
 */
@Service("UserService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {

        List<User> all = userDao.findAll();

        for (User user : all) {
            System.out.println(user + ">>>>>>");
        }

        return all;

    }

    /**
     * 查询user对象
     * @param user
     * @return
     */
    public  User selectByUser(User user){
        User user1 = userDao.selcectbyUser(user);
        return user1;
    }

    /**
    *  Author: 代刘洋
    *  Time：  2017/12/22  0:15
    *  Title: 尝试对resultMap 的理解
    *  Param: 
    *  Response:    
    *
    */


}
