package com.ngyb.study.test.other;

import java.sql.*;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:53
 */
public class SqlServer {

    public static void main(String[] args) {
        String user = "sa";
        String password = "admin";
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:sqlserver://it.nangongyibin.com:1433;DatabaseName=NGYB;";
        String sql = "select * from login";
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, "sa", "Ngyb7219");
            // 建立Statement对象
            stmt = conn.createStatement();
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                System.out.println("学号 "+id+"姓名 "+name+"密码 "+pwd);
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
