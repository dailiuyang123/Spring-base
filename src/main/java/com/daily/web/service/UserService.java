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

//    @Autowired
//    private UserDao userDao;

//    public List<User> findAll(){
//
////        List<User> all = userDao.findAll();
////
////        for (User user : all) {
////            System.out.println(user+">>>>>>");
////        }
//
//        return all;

    public String findAll(){

        System.out.println("hahahha///");
        return "haha";
    }



}
