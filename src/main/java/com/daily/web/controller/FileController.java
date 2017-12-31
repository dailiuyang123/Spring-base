package com.daily.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String uploadFiles(HttpServletRequest request, HttpServletResponse response) {
        //文件上传

        return  null;
    }

}
