package com.ngyb.study.java;

import java.sql.*;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/8/30 17:11
 */
public class Login {
    public static void main(String[] args) {
        loginIn("ngyb", "Liang14c");
    }

    public static void loginIn(String username, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://it.nangongyibin.com:3306/ngyb", "root", "Liang14c");
            String sql = "select * from login where name = ? and pwd = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("登录失败");
        }

    }
}
