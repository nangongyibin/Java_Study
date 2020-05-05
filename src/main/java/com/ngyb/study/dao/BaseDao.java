package com.ngyb.study.dao;


import com.ngyb.study.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {

    public static PreparedStatement prepareStatement(String sql) {
        try {
            Connection conn = JdbcUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
