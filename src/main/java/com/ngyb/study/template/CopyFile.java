package com.ngyb.study.template;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:30
 */
public class CopyFile {

    public static void main(String[] args) {
        CountTime countTime = new CountTime() {
            @Override
            public void code() {
                try {
                    FileOutputStream fos = new FileOutputStream("1_copy.avi");
                    FileInputStream fis = new FileInputStream("1.avi");
                    int len = 0;
                    byte[] buf = new byte[1024];
                    while ((len = fis.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Long codeTime = countTime.getCodeTime();
        System.out.println("用时：" + codeTime);
    }
}
