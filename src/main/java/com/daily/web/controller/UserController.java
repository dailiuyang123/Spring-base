package com.daily.web.controller;

import com.daily.mybatis.entity.JsonMessage;
import com.daily.mybatis.entity.User;

import com.daily.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17600 on 2017/8/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     *
     * @return
     */
    @RequestMapping(value = "/findAll.do", method = RequestMethod.POST)
    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        JsonMessage jsonMessage = new JsonMessage();
        String contextPath = request.getContextPath();
        String method = request.getMethod();
        String user = request.getParameter("user");

        logger.info("contextPath:"+contextPath);
        logger.info("method:"+method);

        List<User> all = userService.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        request.setAttribute("users",all);
        map.put("user", all);
        jsonMessage.setData(map);
        String requestURI = request.getRequestURI();
        logger.info("-------------------------------"+requestURI+"---------------------------");
        return "redirect:/main/Document.jsp";

    }


//    @RequestMapping(value = "login.do", method = RequestMethod.POST)
//    public JsonMessage login(HttpServletRequest request, HttpServletResponse response) {
//        JsonMessage jsonMessage = new JsonMessage();
//        logger.debug("用户登录");
//        Map<String, Object> params = ParamsUtil.getParams(request);
//
//
//        return jsonMessage;
//
//    }


}
