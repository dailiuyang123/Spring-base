package com.daily.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Azir on 2018/1/29.
 */
public class FileUtils {


    /**
    *  Author: 代刘洋
    *  Time：  2018/1/29  23:27
    *  Title:     FileUpload
    *  Param:
    *  Response:
    *  文件上传功能
    */

    public Map FileUpload(HttpServletRequest request){
        Map paramMap=new HashMap();
        //文件上传
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安
        String savePath = this.getClass().getResource("/").getPath();


        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }

        //使用Apache文件上传组件处理文件上传步骤
        try {
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return  null ;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项

            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                //得到上传的文件名称
                //判断是否是文件
                if (fileItem.isFormField()){
                    //不是文件数据
                }else {
                    String fileName = fileItem.getName();
                    paramMap.put("fileName",fileName);
                    System.out.println(fileName);
                    if(fileName==null || fileName.trim().equals("")){
                        continue;
                    }

                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    //获取item中的上传文件的输入流
                    InputStream in = fileItem.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + fileName);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    fileItem.delete();
                    String message = "文件上传成功！";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message="文件上传失败！";
        }
       return paramMap;
    }


}
