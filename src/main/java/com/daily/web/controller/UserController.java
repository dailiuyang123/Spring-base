package com.daily.web.controller;

import com.daily.mybatis.entity.JsonMessage;
import com.daily.mybatis.entity.User;
import com.daily.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17600 on 2017/8/15.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping(value = "/findAll.do",method = RequestMethod.POST)
    public JsonMessage findAll(HttpServletRequest request, HttpServletResponse response){
        JsonMessage jsonMessage=new JsonMessage();
        List<User> all = userService.findAll();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("user",all);
        jsonMessage.setData(map);
        return jsonMessage;
    }


}
