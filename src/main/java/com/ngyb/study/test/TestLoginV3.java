package com.ngyb.study.test;


import com.ngyb.study.dao.TimeSettingDao;
import com.ngyb.study.utils.RSACrypt;
import com.ngyb.study.utils.Util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;

/**
 * 测试LoginV3接口
 */
public class TestLoginV3 {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        // String username = "ngyb";
        // String password = "25d55ad283aa400af464c76d713c07ad";
        // String timestamp = "1509253528624";
        // String input = "username="+username+"&password="+password+"" +
        // "&timestamp=" + timestamp;
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        // PublicKey publicKey =
        // RSACrypt.getPublicKey(TimeSettingDao.getPublicKey());
        // String sign = RSACrypt.sign(privateKey, input);
        //
        // boolean verify = RSACrypt.verify(publicKey, input, sign);
        // System.out.println(verify);
        testLoginV3();
    }

    public static void testLoginV3() {
        try {
            long timestamp = System.currentTimeMillis();
            String input = "username=ngyb&password=25d55ad283aa400af464c76d713c07ad" + "&timestamp=" + timestamp;
            PrivateKey privateKey = RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
            String sign = RSACrypt.sign(privateKey, input);
            System.out.println(sign);
            String input2 = "username=ngyb&password=25d55ad283aa400af464c76d713c07ad" + "&timestamp=" + "1509204780437";
            URL url = new URL("http://127.0.0.1:8080/EncryptServer/login_v5?" + input + "&sign=" + sign);
            System.out.println(url.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // conn.setRequestMethod("POST");
            InputStream is = conn.getInputStream();
            String result = Util.inputStream2String(is);
            is.close();
            System.out.println("method:" + conn.getRequestMethod());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
