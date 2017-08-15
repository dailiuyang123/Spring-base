package com.daily.web.controller;

import com.daily.mybatis.entity.JsonMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 17600 on 2017/8/15.
 */
@Controller
@RequestMapping("/word")
public class WordController {

    /**
     * 文档导出
     */
    @RequestMapping(value = "/getWorld.do", method = RequestMethod.POST)
    public JsonMessage getWord(){
        JsonMessage jsonMessage=new JsonMessage();

        return jsonMessage;
    }
}
