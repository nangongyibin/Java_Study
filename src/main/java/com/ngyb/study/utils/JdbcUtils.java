package com.ngyb.study.utils;


import com.ngyb.study.db.JdbcPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc工具类
 */
public final class JdbcUtils {
    private static JdbcPool jdbcPool = new JdbcPool();

    private JdbcUtils() {
    }

    /**
     * 建立连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return jdbcPool.getConnection();
    }

    /**
     * 释放资源
     */
    public static void free(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    jdbcPool.free(connection);
                }
            }
        }
    }
}
