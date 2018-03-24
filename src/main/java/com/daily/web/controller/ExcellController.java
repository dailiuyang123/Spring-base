package com.daily.web.controller;



import com.daily.util.ExcellUtil;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Azir on 2018/2/25.
 */

@RestController
@RequestMapping("/Excell")
public class ExcellController {

    @RequestMapping(value = "/exportExcell",method = RequestMethod.POST)
    public void  exportExcesll(HttpServletRequest request, HttpServletResponse response){
            try {

                // 初始化数据
                List data=new ArrayList();
                for (int i=0;i<2;i++){
                    Map map=new HashMap();
                    map.put("No",i+"");
                    map.put("name","机器号"+i);
                    map.put("sex","待设定");
                    map.put("age","1");
                    data.add(map);
                }
                File file=new File("D:\\test.xlsx");
                if (!file.exists()){
                    file.createNewFile();
                }
                OutputStream outputStream=new FileOutputStream(file);
                ExcellUtil.createExcel(data,outputStream,request);
            }catch (Exception e){
                e.printStackTrace();
            }

    }


}
