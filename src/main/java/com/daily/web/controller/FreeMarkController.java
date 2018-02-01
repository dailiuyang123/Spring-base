package com.daily.web.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Azir on 2017/12/26.
 */
@Controller
@RequestMapping("/word")
public class FreeMarkController {

    /**
    *  Author: 代刘洋
    *  Time：  2017/12/26  21:29
    *  Title:
    *  Param:
    *  Response:
     * problem: 目前获得模板的路径是绝对路径，现在无法解决相对路径问题
     *                  现在的文件仍是简单的doc文件
     *                  当doc,转换.web文件时。转换格式存在问题。需要转换格式后。手动修改.ftl
    *  descrption: 测试用freemark 导出 word文档
    */
    @RequestMapping(value = "/getWords",method = RequestMethod.POST )
    public void   getWord(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String requestURI = request.getRequestURI();
        String realPath = request.getRealPath("/");
        System.out.println(realPath);
        System.out.println(requestURI);
        request.setCharacterEncoding("UTF-8");
        //创建配置实例
        Configuration configuration = new Configuration();

        //设置编码
        configuration.setDefaultEncoding("UTF-8");

        //ftl模板文件统一放至 com.lun.template 包下面
        //configuration.setClassForTemplateLoading(FreeMarkController.class,"/ftl");
        try {
            //直接获得路径
            String filePath1=FreeMarkController.class.getResource("/").getPath()+"templet";
            //String filePath2="D:\\GitHub\\spring-base\\target\\classes\\templet";
            configuration.setDirectoryForTemplateLoading(new File(filePath1));
        //获取模板
        Template template = null;

            template = configuration.getTemplate("free.ftl");

        String filePath="F:\\words";
        String fileName="free.doc";
        //输出文件
        File outFile = new File(filePath+File.separator+fileName);

        //如果输出目标文件夹不存在，则创建
        if (!outFile.getParentFile().exists()){
            outFile.getParentFile().mkdirs();
        }

        //将模板和数据模型合并生成文件
        Writer out = null;

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            Map dataMap=new HashMap();
            dataMap.put("userName","admin");
        //生成文件
        template.process(dataMap, out);

        //关闭流
        out.flush();
        out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
