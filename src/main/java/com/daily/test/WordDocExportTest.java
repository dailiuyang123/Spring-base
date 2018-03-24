package com.daily.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * word导出
 * Created by Ay on 2016/6/27.
 */
public class WordDocExportTest {

    public static void main(String[] args) throws Exception{
        /** 初始化配置文件 **/
        Configuration configuration = new Configuration();
        /** 设置编码 **/
        configuration.setDefaultEncoding("utf-8");
        /** 我的ftl文件是放在D盘的**/
        String fileDirectory = "E:\\";
        /** 加载文件 **/
        configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
        /** 加载模板 **/
        Template template = configuration.getTemplate("resume.ftl");
        /** 准备数据 **/


        /** 指定输出word文件的路径 **/
        String outFilePath = "E:\\myFreeMarker.doc";
        File docFile = new File(outFilePath);
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        //template.process(dataMap,out);

        if(out != null){
            out.close();
        }
    }
}

