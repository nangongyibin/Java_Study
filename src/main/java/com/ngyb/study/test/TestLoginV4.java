package com.ngyb.study.test;


import com.ngyb.study.dao.TimeSettingDao;
import com.ngyb.study.utils.RSACrypt;

import java.security.PrivateKey;

/**
 * 测试LoginV3接口
 */
public class TestLoginV4 {

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
            String input = "username=HelloWorld&password=7188E59938C2D0BA327E160DB36A37AB" + "&timestamp=" + timestamp;
            PrivateKey privateKey = RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
            String sign = RSACrypt.sign(privateKey, input);
            System.out.println(sign);
            String md5Verify = "http://localhost:8080/EncryptServer/login_v6?" + input + "&sign=" + sign;
            System.out.println(md5Verify);
//			URL url = new URL("http://127.0.0.1:8080/EncryptServer/login_v4?" + input + "&sign=" + sign);
//			System.out.println(url.toString());
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // conn.setRequestMethod("POST");
//			InputStream is = conn.getInputStream();
//			String result = Util.inputStream2String(is);
//			is.close();
//			System.out.println("method:" + conn.getRequestMethod());
//			System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
