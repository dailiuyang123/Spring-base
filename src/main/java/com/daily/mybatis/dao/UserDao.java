package com.daily.mybatis.dao;

import com.daily.mybatis.entity.User;

import java.util.List;

/**
 * Created by 11851 on 2017/8/13.
 */

public interface UserDao {

    public List<User> findAll();

}
