package com.ngyb.study.test.other;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 16:02
 */
public class FTP {

    public static void main(String[] args) {
        testUpload();
    }

    private static void testUpload() {
        FileInputStream fis = null;
        FTPClient ftpClient= null;
        try {
            ftpClient = new FTPClient();
            ftpClient.connect("47.105.71.243");
//        ftpClient.login("ngyb","123");
            File srcFile = new File("file/ngyb.pdf");
            fis = new FileInputStream(srcFile);
            //设置上传目录
//            ftpClient.changeWorkingDirectory("/lanjie/pic");
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile("tt.pdf", fis);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                IOUtils.closeQuietly(fis);
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
