package com.ngyb.study.io;

import java.io.*;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/18 22:16
 */
public class Test {
    public static final String path = "servel.txt";
    public static final String path_old = "a.txt";
    public static final String serverPath = "http://it.nangongyibin.com:8080/resource/a.txt";
    public static final String path1 = "Nidongde.wav";

    public static void main(String[] args) {
        IOUtils.inputNetNextFile(serverPath,"1.avi",0,3);
        IOUtils.inputNetNextFile(serverPath,"2.avi",0,3);
        IOUtils.inputNetNextFile(serverPath,"3.avi",0,3);
        File file = new File("F:\\Java\\Java_Study");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".avi");
            }
        });
        File nextFile = new File("serverinfos.txt");
        for (File file1 : files) {
            InputStream in = null;
            OutputStream os = null;
            try {
                in = new FileInputStream(file1);
                os = new FileOutputStream(nextFile,true);
                byte[] arr = new byte[1024];
                int a = 0;
                while ((a = in.read(arr))!=-1){
                    os.write(arr,0,a);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        IOUtils.outputFile(path);
        IOUtils.outputMaxFile(path1);
        IOUtils.inputFile(path);
        IOUtils.inputNetFile(serverPath,"1.txt");
    }
}
