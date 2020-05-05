package com.ngyb.study.dao;


import com.ngyb.study.db.TimeSettingTable;
import com.ngyb.study.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeSettingDao implements TimeSettingTable {

    /**
     * 获取用户登录过期毫秒
     *
     * @return
     */
    public static int getLoginExpired() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int expired = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select " + COLUMN_LOGIN_EXPIRED + " from " + TABLE_NAME;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                expired = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return expired;
    }

    /**
     * 获取数据库存储RSA公钥信息
     *
     * @return
     */
    public static String getPublicKey() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String publicKey = "";
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select " + COLUMN_PUB_KEY + " from " + TABLE_NAME;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                publicKey = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return publicKey;
    }

    /**
     * 获取数据库存储RSA私钥信息
     *
     * @return
     */
    public static String getPrivateKey() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String privateKey = "";
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select " + COLUMN_PRI_KEY + " from " + TABLE_NAME;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                privateKey = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return privateKey;
    }
}
