package com.daily.web.controller;

import com.daily.mybatis.entity.JsonMessage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 11851 on 2017/9/25.
 */

@RestController
@RequestMapping("/httpClient")
public class HttpRequestController {


    /**
     * 用HttpClient 模拟一个POST请求
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public  String  getRequest(HttpServletRequest request, HttpServletResponse response)  {
        JsonMessage jsonMessage=new JsonMessage();
        HttpSession session = request.getSession();
        String contextPath = request.getContextPath();
        //请求路径
        String url="http://localhost:8989/SpringBase/user/findAll.do";
        //创建httpClient
        HttpClient httpClient = new DefaultHttpClient();
        //选择请求方式POST
        HttpPost post = new HttpPost(url);
        // 构造消息头
        post.setHeader("Content-type", "application/json; charset=utf-8");

        //执行
        String body="";
        HttpResponse execute=null;
        try {
             execute = httpClient.execute(post);
            //获取结果实体
            HttpEntity entity = execute.getEntity();
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

       return body;

    }



}
