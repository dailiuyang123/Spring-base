package com.daily.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.daily.util.FileUtils;
import com.daily.util.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Azir on 2018/3/30.
 *  des: 进行权限判定：token
 */
@Component
public class PowerFilter implements Filter {

    @Value("${white.list}")
    private String whiteList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String method = httpServletRequest.getMethod();
        String requestURI = httpServletRequest.getRequestURI();
        System.out.println("请求方式为：" + method);
        System.out.println("请求路径为："+requestURI);
        //白名单校验
        String s = this.readProperties();
        //读取 文件内的数据
        System.out.println("whiteList:"+s);
        boolean b = this.whiteList(requestURI,s);
        if (b){
            chain.doFilter(request, response);
            return;
        }
        if (method.equalsIgnoreCase("get")) {  // get方式不进行拦截
            chain.doFilter(request, response);
            return;
        } else if (method.equalsIgnoreCase("post")) {  //post 请求进行 token 校验
            ServletInputStream inputStream = httpServletRequest.getInputStream();
            byte[] bytes = FileUtils.readFromStream(inputStream);
            Map paramMap =(Map) JSONObject.parseObject(bytes, Map.class);
            String token = paramMap.get("token").toString();
            Jedis jedis = RedisUtil.getJedis();
            Boolean exists = jedis.exists(token);
            if (exists){
                chain.doFilter(httpServletRequest, response);
            }else {
                return;
            }
        }


    }


    @Override
    public void destroy() {

    }

    //白名单校验
    public  boolean  whiteList(String url,String whiteList){
        String[] split = whiteList.split(",");
        for (String s : split) {
            boolean b = url.endsWith(s);
            if (b){
                return true;
            }
        }

        return  false;
    }

    //读取配置文件
    public String readProperties() throws FileNotFoundException {
        String path = PowerFilter.class.getResource("/").getPath() + "/whiteList.properties";
        File file=new File(path);
        FileInputStream in=new FileInputStream(file);
        byte[] bytes = FileUtils.readFromStream(in);
        Map paramMap =(Map) JSONObject.parseObject(bytes, Map.class);
        String s = paramMap.get("white.list").toString();
        return s;
    }


}
