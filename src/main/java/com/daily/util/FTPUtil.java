package com.daily.util;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;


import java.io.*;

/**
 * Created by Azir on 2017/11/21.
 */
public class FTPUtil {
    /**
     * 本地文件名
     */
    private String localfilename;
    /**
     * 远程文件名
     */
    private String remotefilename;
    /**
     * FTP客户端
     */
    private FtpClient ftpClient;

    /**
     * 服务器连接
     *
     * @param ip       服务器IP
     * @param port     服务器端口
     * @param username 用户名
     * @param password 密码
     * @param path     服务器路径
     * @author 周玲斌
     * @date 2012-7-11
     */
    public boolean uploadFile(String ip, int port, String username, String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(ip, port);
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);//登录

            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                ftp.disconnect();
                return success;
            }
            boolean b = ftp.changeWorkingDirectory(path);
            System.out.println("文件上传路经切换"+b);
            //重要
            boolean b1 = ftp.storeFile(filename, input);
            System.out.println("文件上传结果"+b1);
            input.close();
            ftp.logout();
            success = true;
            return success;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public static void main(String[] args) {
        FTPUtil ftpUtil = new FTPUtil();
        // ftpUtil.uploadFile("192.168.221.128",21,"Azir","123456");
//        boolean azir = ftpUtil.getConnect("192.168.221.128", 21, "Azir", "123456");
        try {
            FileInputStream in=new FileInputStream(new File("E:/test2.txt"));
            String fileName="test2.txt";
            boolean result = ftpUtil.uploadFile("192.168.221.128", 21, "Azir", "123456", "/home/Azir", fileName, in);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //上传文件


    }

    /**
     * 获得连接
     *
     * @return
     */
    public boolean getConnect(String ip, int port, String userName, String passworld) {

        FTPClient ftp = new FTPClient();

        try {
            ftp.connect(ip, port);
            ftp.login(userName, passworld);//登录
            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                ftp.disconnect();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * 下载文件
     *
     * @param remoteFile 远程文件路径(服务器端)
     * @param localFile  本地文件路径(客户端)
     * @author 周玲斌
     * @date 2012-7-11
     */
//    public void download(String remoteFile, String localFile) {
//        TelnetInputStream is = null;
//        FileOutputStream os = null;
//        try {
//            //获取远程机器上的文件filename，借助TelnetInputStream把该文件传送到本地。
//            is = ftpClient.get(remoteFile);
//            File file_in = new File(localFile);
//            os = new FileOutputStream(file_in);
//            byte[] bytes = new byte[1024];
//            int c;
//            while ((c = is.read(bytes)) != -1) {
//                os.write(bytes, 0, c);
//            }
//            System.out.printaln("download success");
//        } catch (IOException ex) {
//            System.out.println("not download");
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        } finally {
//            try {
//                if (is != null) {
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (os != null) {
//                        os.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


}
