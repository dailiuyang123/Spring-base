package com.daily.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.daily.common.Constants;
import com.daily.common.Exception.ValidateParamterException;
import com.daily.mybatis.entity.JsonMessage;

import com.daily.mybatis.entity.User;
import com.daily.util.ParamUtils;
import com.daily.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17600 on 2017/8/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    //Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     *
     * @return
     */
    @RequestMapping(value = "/findAll.do", method = RequestMethod.POST)
    public ModelAndView findAll(HttpServletRequest request, HttpServletResponse response, User user) {
        JsonMessage jsonMessage = new JsonMessage();
        //工具类
        Map paramMap = ParamUtils.getParam(request);
        System.out.println(user.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        jsonMessage.setData(map);
        String requestURI = request.getRequestURI();
        //模块和视图
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/main/Document.jsp");
        mv.addObject("userName", "admin");
        return mv;

    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        Map map = ParamUtils.getParam(request);
        String userstring = JSONObject.toJSONString(map);
        User user = JSONObject.parseObject(userstring, User.class);
        User userByUser = userService.getUserByUser(user);
        ModelAndView mv=new ModelAndView();
        if (userByUser == null) {
            String error="用户名或密码不正确";
            mv.addObject("error",error);
            //如果是redirect 重定向，则前端则拿不到 modelAndView 内的值
            //并且 redirect,后的viewName必须是全路径带上jsp后缀的
            //必须是forward 的范围才生效
            //forward 则不用
            mv.setViewName("redirect:/WebRoot/login.jsp");
        } else {
            mv.addObject(user);
            mv.setViewName("/WebRoot/index");
        }
        return mv;
    }


    /**
    *  Author: 代刘洋
    *  Time：  2018/2/3  14:51
    *  Title:   用户注册
    *  Param:
    *  Response:
    *
    */

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public JsonMessage addUser(HttpServletRequest request,HttpServletResponse response){
        JsonMessage jsonMessage=new JsonMessage();
        Map map = ParamUtils.getParam(request);
        ModelAndView modelAndView=new ModelAndView();
        try {
            userService.addUser(map);
            modelAndView.setViewName("");
        }catch (Exception e){

        }
        return jsonMessage;
    }



}
