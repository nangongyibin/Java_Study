package com.ngyb.study.dao;

import com.ngyb.study.bean.User;
import com.ngyb.study.db.UserTable;
import com.ngyb.study.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户dao
 */
public class UserDao extends BaseDao implements UserTable {
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id, username, password, timestamp from users";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String timestamp = rs.getString(4);
                User user = new User(id, username, password, timestamp);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return list;
    }

    /**
     * 是否存在用户
     *
     * @param username
     * @return
     */
    public boolean exitUser(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Connection conn = JdbcUtils.getConnection();
            String sql = "select count(1) from " + TABLE_NAME + " where " + COLUMN_USERNAME + "=?";
            //PreparedStatement ps = conn.prepareStatement(sql);
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return false;
    }

    /**
     * 数据库是否存在用户
     *
     * @param user
     * @return
     */
    public boolean exitUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Connection conn = JdbcUtils.getConnection();
            String sql = "select count(1) from " + TABLE_NAME + " where " + COLUMN_USERNAME + "=?";
            //PreparedStatement ps = conn.prepareStatement(sql);
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return false;
    }

    /**
     * 校验密码
     *
     * @param password
     * @return
     */
    public boolean verifyPassword(String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Connection conn = JdbcUtils.getConnection();
            String sql = "select count(1) from " + TABLE_NAME + " where " + COLUMN_PASSWORD + "=?";
            //PreparedStatement ps = conn.prepareStatement(sql);
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return false;
    }

    public boolean verifyPassword(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Connection conn = JdbcUtils.getConnection();
            String sql = "select count(1) from " + TABLE_NAME + " where " + COLUMN_PASSWORD + "=? and " + COLUMN_USERNAME + "=?";
            //PreparedStatement ps = conn.prepareStatement(sql);
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            rs = ps.executeQuery();
            int count = 0;
            if (rs.first()) {
                count = rs.getInt(1);
            }
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return false;
    }


    /**
     * 注册新用户
     *
     * @param username
     * @param password
     * @return
     */
    public boolean registerUser(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            boolean exitUser = exitUser(username);
            if (exitUser) {
                System.out.println("用户已经存在");
                return false;
            }
            String sql = "insert into " + TABLE_NAME + "(" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + "," + COLUMN_TIMESTAMP + ") values(?,?,?)";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, System.currentTimeMillis() + "");
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return false;
    }

    /**
     * @param user
     * @deprecated 登录是否过期
     */
    public void expired(User user) {
    }

    /**
     * 根据用户名查询用户id
     *
     * @param username
     * @return
     */
    public int getUserId(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userId = 0;
        try {
            //Connection conn = JdbcUtils.getConnection();
            String sql = "select " + COLUMN_ID + " from " + TABLE_NAME + " where " + COLUMN_USERNAME + "=?";
            //PreparedStatement ps = conn.prepareStatement(sql);
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                userId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return userId;
    }
}
