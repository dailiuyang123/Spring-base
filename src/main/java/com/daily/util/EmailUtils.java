package com.daily.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 11851 on 2017/11/12.
 */
public class EmailUtils {

    public  static void main(String[] args) throws Exception {

        //1. 登陆邮件客户端(创建会话session)
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        //创建了session会话
        Session session = Session.getDefaultInstance(prop);
        //设置debug模式来调试发送信息
        session.setDebug(true);
        //创建一封邮件对象
        Message message = new MimeMessage(session);
        //写信
        message.setSubject("欢迎访问我的CSDN博客主页！");
        //正文内容
        message.setContent("欢迎访问我的CSDN博客主页：http://blog.csdn.net/eson_15"
                + "，么么哒~", "text/html;charset=utf-8");
        //附件人地址
        message.setFrom(new InternetAddress("17600608814@163.com"));
        Transport transport = session.getTransport();
        //链接邮件服务器的认证信息
        transport.connect("smtp.163.com", "17600608814@163.com", "dai513115");
        // 设置收件人地址，并发送邮件
        transport.sendMessage(message, new InternetAddress[]{new InternetAddress("17600608814@163.com")});
        transport.close();
    }


}
