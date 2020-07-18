package com.ngyb.study.io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/18 21:40
 */
public class IOUtils {

    public static  void inputFile(String path){
        File file = new File(path);
        InputStream is = null;
        try {
            is =new FileInputStream(file);
            byte[] arr = new byte[1024];
            while ((is.read(arr))!=-1){
                System.out.println(new String(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void outputFile(String path){
        File file = new File(path);
        OutputStream os = null;
        try {
            os =new FileOutputStream(file);
            os.write("1024程序员节".getBytes());
            System.out.println("hhhh");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void outputMaxFile(String path){
        File file = new File(path);
        OutputStream os = null;
        try {
            os =new FileOutputStream(file);
            byte[] buf = new byte[1024];
            for (int i = 0; i < 1024 * 2; i++) {
                os.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputNetFile(String path,String filepath){
        File file = new File(filepath);
        OutputStream output = null;
        InputStream input = null;
        try {
            URL url = new URL(path);
            output = new FileOutputStream(file);
            input = url.openStream();
            byte[] arr = new byte[1024];
            int a = 0;
            while ((a = input.read(arr))!=-1){
                output.write(arr,0,a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputNetNextFile(String path,String filepath,int start,int end){
        File file = new File(filepath);
        OutputStream output = null;
        InputStream input = null;
        try {
            URL url = new URL(path);
            input = url.openStream();
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.addRequestProperty("Range","bytes="+start+"-"+end);
            input = huc.getInputStream();
            output = new FileOutputStream(file);
            byte[] arr = new byte[1024];
            int a = 0;
            while ((a = input.read(arr))!=-1){
                output.write(arr,0,a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
