package com.daily.web.controller;

import com.daily.util.FileUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Azir on 2017/11/21.
 */

@Controller
@RequestMapping("/files")
public class FileController {

    /**
     * 文件上传
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadFiles(HttpServletRequest request, HttpServletResponse response) {
        FileUtils fileUtils=new FileUtils();
        Map map = fileUtils.FileUpload(request);
    }

}
