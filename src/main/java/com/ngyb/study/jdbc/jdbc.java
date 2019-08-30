package com.ngyb.study.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/8/30 13:39
 */
public class jdbc {

    @Test
    public void jdbcTest() {
        try {
            //DriverManager.deregisterDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://it.nangongyibin.com:3306/ngyb", "root", "Liang14c");
            Statement statement = con.createStatement();
            String sql = "select * from orders";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                System.out.println("id：" + id + "====姓名：" + name + "====价格：" + price);
            }
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
