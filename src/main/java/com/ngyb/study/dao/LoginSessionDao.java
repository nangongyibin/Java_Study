package com.ngyb.study.dao;


import com.ngyb.study.bean.User;
import com.ngyb.study.db.LoginSesstionTable;
import com.ngyb.study.utils.JdbcUtils;
import com.ngyb.study.utils.MD5Util;
import com.ngyb.study.utils.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSessionDao implements LoginSesstionTable {

    /**
     * 插入数据
     *
     * @param userId
     * @param token
     * @return
     */
    public static boolean insert(int userId, String token) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            String sql = "insert into " + TABLE_NAME + "(" + COLUMN_TOKEN + ", " + COLUMN_TIMESTAMP + "," + COLUMN_USER_ID + ") values(?,?,?)";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, token);
            ps.setString(2, TimeUtil.getCurTimestamp() + "");
            ps.setInt(3, userId);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return result > 0;
    }

    /**
     * 更新token
     *
     * @param userId
     * @param token
     * @return
     */
    public static boolean update(int userId, String token) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            String sql = "update " + TABLE_NAME + " set " + COLUMN_TOKEN + "=? where " + COLUMN_USER_ID + "=?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, token);
            ps.setInt(2, userId);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return result > 0;
    }

    /**
     * 是否已经生成过token
     *
     * @param user 用户
     * @param sign 签名
     * @return
     */
    public static boolean exitToken(User user, String sign) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            String sql = "select count(1) from " + TABLE_NAME + " where " + COLUMN_TOKEN + "=? and " + COLUMN_USER_ID + "=?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, generateMd5Token(user, sign));
            ps.setInt(2, UserDao.getInstance().getUserId(user.getUsername()));
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return result > 0;
    }

    public static String generateMd5Token(User user, String sign) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username=" + user.getUsername()).append("&password=" + user.getPassword()).append("&timestamp=" + user.getTimestamp()).append("&sign=" + sign);
        return MD5Util.md5(stringBuilder.toString());
    }

    /**
     * 用户登录过：login_session表存储过用户id，说明登录过
     *
     * @param user
     * @return
     */
    public static boolean hasLogin(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            String sql = "select count(1) from " + TABLE_NAME + " where " + COLUMN_USER_ID + "=?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            int userId = UserDao.getInstance().getUserId(user.getUsername());
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.first()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return result > 0;
    }
}
