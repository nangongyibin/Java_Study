package com.ngyb.study.bean;


import com.ngyb.study.utils.TextUtils;

public class User {
    private int id;
    private String username;
    private String password;
    private String timestamp;
    private String sign;

    public User() {
        super();
    }

    public User(int id, String username, String password, String timestamp) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.timestamp = timestamp;
    }

    public User(int id, String username, String password, String timestamp, String sign) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.timestamp = timestamp;
        this.sign = sign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        if (TextUtils.isEmpty(sign)) sign = "";
        return sign.replace(" ", "+");
    }

    public void setSign(String sign) {
        //还原+号：Window会把+号变成空格
        if (TextUtils.isEmpty(sign)) {
            sign = "";
        }
        //String sign = request.getParameter("sign").replaceAll(" ", "+");
        this.sign = sign.replace(" ", "+");
    }

    /**
     * 获取RSA签名需要的参数
     *
     * @return
     */
    public String getRsaParams() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username=" + username + "&");
        stringBuilder.append("password=" + password + "&");
        stringBuilder.append("timestamp=" + timestamp);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", timestamp=" + timestamp + ", sign=" + sign + "]";
    }
}
