package com.ngyb.study.test;

import com.alibaba.fastjson.JSONObject;
import com.ngyb.study.bean.User;
import com.ngyb.study.dao.UserDao;
import com.ngyb.study.utils.JdbcUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestConnection {
    /**
     * 测试连接
     */
    public static void main(String[] args) {
//		testConne();
        //testGetUsers();
        //boolean exitUser = UserDao.getInstance().exitUser("Boy2");
		/*boolean registerUser = UserDao.getInstance().registerUser("Heima777", "7188E59938C2D0BA327E160DB36A37AB");
		System.out.println(registerUser);*/
        new Thread(new Runnable() {
            public void run() {
                try {
                    HttpClient client = new DecompressingHttpClient();
                    JSONObject json = new JSONObject();
                    json.put("username", "jiyouliang");
                    json.put("password", "12345678");
                    HttpGet get = new HttpGet("http://localhost:8080//EncryptionAlgorithmServer/userRegister?username=ngyb&password=1234324");
                    client.execute(get);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void testGetUsers() {
        List<User> list = UserDao.getInstance().getAllUsers();
        System.out.println(list.toString());
    }

    public static void testConne() {
        try {
            Connection c = JdbcUtils.getConnection();
            PreparedStatement ps = c.prepareStatement("select username from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                System.out.println(username);
            }
            JdbcUtils.free(rs, ps, c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
