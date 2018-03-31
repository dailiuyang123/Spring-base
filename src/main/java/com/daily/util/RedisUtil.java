package com.daily.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Azir on 2018/3/30.
 */
public class RedisUtil {
    /**
    *  Author: 代刘洋
    *  Time：  2018/3/30  23:33
    *  Title:
    *  Param:
    *  Response: 获取redis实例对象
    *
    */
    public static Jedis getJedis(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-redis.xml");
        JedisPool jedisPool = context.getBean(JedisPool.class);
        Jedis resource = jedisPool.getResource();
        return resource;
    }

}
