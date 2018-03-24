package com.daily.web.service;

import com.alibaba.fastjson.JSONObject;
import com.daily.common.Exception.ValidateParamterException;
import com.daily.mybatis.dao.UserMapper;
import com.daily.mybatis.entity.User;
import com.daily.mybatis.entity.UserExample;
import com.daily.util.IdGenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 11851 on 2017/8/13.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;




    /**
    *  Author: 代刘洋
    *  Time：  2018/1/20  14:10
    *  Title:
    *  Param:
    *  Response:
    *
    */
    public User getUserByUser(User user){
        StringBuilder sb=new StringBuilder();
        sb.append("select  *  from tbl_user where real_name=? and password=?");
        User user1=null;
        try {
            ParameterizedBeanPropertyRowMapper<User> userParameterizedBeanPropertyRowMapper = ParameterizedBeanPropertyRowMapper.newInstance(User.class);
            user1 = jdbcTemplate.queryForObject(sb.toString(), new Object[]{user.getReal_name(),  user.getPassword()}, userParameterizedBeanPropertyRowMapper);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user1;
    }

    /**
    *  Author: 代刘洋
    *  Time：  2018/1/26  23:43
    *  Title:  添加用户
    *  Param:
    *  Response:
    *
    */

    public void addUser(Map paramMap) throws ValidateParamterException {
        String userStr = JSONObject.toJSONString(paramMap);
        User user = JSONObject.parseObject(userStr, User.class);
        //判断用户是否存在
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(user.getEmail()).andReal_nameEqualTo(user.getReal_name());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0) {//入库
            user.setId(IdGenUtils.UUID());
            userMapper.insertSelective(user);
        } else {
            throw new ValidateParamterException("用户名或密码已被占用");
        }
    }





}
