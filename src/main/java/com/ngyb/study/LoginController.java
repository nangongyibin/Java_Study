package com.ngyb.study;

import com.alibaba.fastjson.JSONObject;
import com.ngyb.study.bean.User;
import com.ngyb.study.constant.Constants;
import com.ngyb.study.dao.LoginSessionDao;
import com.ngyb.study.dao.TimeSettingDao;
import com.ngyb.study.dao.UserDao;
import com.ngyb.study.utils.RSACrypt;
import com.ngyb.study.utils.TextUtils;
import com.ngyb.study.utils.TimeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PublicKey;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/13 17:36
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController extends BaseController implements Constants {

    @RequestMapping(value = "loginServlet", method = {RequestMethod.GET, RequestMethod.POST})
    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("abc") && password.equals("123")) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failure");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    protected void login1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacte(response);
        //String result = parserRequest(request);
        User user = parserRequest(request, User.class);
        UserDao dao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        verifyLogin(response, user, dao, json);
    }

    @RequestMapping(value = "login_v2", method = {RequestMethod.GET, RequestMethod.POST})
    protected void login2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacte(response);
        // String result = parserRequest(request);
        User user = parserRequest(request, User.class);
        System.out.println(user.toString());
        UserDao dao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        verifyLogin1(response, user, dao, json);
    }

    @RequestMapping(value = "login_v3", method = {RequestMethod.GET, RequestMethod.POST})
    protected void login3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacte(response);
        // String result = parserRequest(request);
        User user = parserRequest(request, User.class);
        UserDao dao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        verifyLogin2(response, user, dao, json);
//		verifyLoginNew(request, response, user, dao, json);
    }

    @RequestMapping(value = "login_v4", method = {RequestMethod.GET, RequestMethod.POST})
    protected void login4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacte(response);
        // String result = parserRequest(request);
        User user = parserRequest(request, User.class);
        UserDao dao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        verifyLogin3(response, user, dao, json);
//		verifyLoginNew(request, response, user, dao, json);
    }

    @RequestMapping(value = "login_v5", method = {RequestMethod.GET, RequestMethod.POST})
    protected void login5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacte(response);
        // String result = parserRequest(request);
        User user = parserRequest(request, User.class);
        UserDao dao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        verifyLogin4(response, user, dao, json);
//		verifyLoginNew(request, response, user, dao, json);
    }

    @RequestMapping(value = "login_v6", method = {RequestMethod.GET, RequestMethod.POST})
    protected void login6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacte(response);
        // String result = parserRequest(request);
        User user = parserRequest(request, User.class);
        UserDao dao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        verifyLogin5(response, user, dao, json);
//		verifyLoginNew(request, response, user, dao, json);
    }

    /**
     * 校验用户登录信息
     *
     * @param response
     * @param user
     * @param dao
     * @param json
     * @return
     */
    public void verifyLogin(HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        //没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        //没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        //用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        //密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        //登录成功
        loginSuccess(response, json);
    }

    /**
     * 校验用户登录信息
     *
     * @param response
     * @param user
     * @param dao
     * @param json
     * @return
     */
    public void verifyLogin1(HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        //缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        //登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        //登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            System.out.println(TimeSettingDao.getLoginExpired());
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        // 登录成功
        loginSuccess(response, json);
    }

    /**
     * 校验用户登录信息
     *
     * @param response
     * @param user
     * @param dao
     * @param json
     * @return
     */
    private void verifyLogin2(HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        if (TextUtils.isEmpty(user.getSign())) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        PublicKey publicKey = RSACrypt.getPublicKey(TimeSettingDao.getPublicKey());
        String input = user.getRsaParams();
        // String sign = RSACrypt.sign(rsaParams);
        boolean verify = RSACrypt.verify(publicKey, input, user.getSign());
        if (!verify) {
            json.put(KEY_MSG, "RSA签名校验失败");
            json.put(KEY_CODE, CODE_RSA_SIGN_ERROR);
            writeJson(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        // 登录成功
        loginSuccess(response, json);
    }


    /**
     * 校验用户登录信息
     *
     * @param response
     * @param user
     * @param dao
     * @param json
     * @return
     */
    private void verifyLogin3(HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        if (TextUtils.isEmpty(user.getSign())) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        PublicKey publicKey = RSACrypt.getPublicKey(TimeSettingDao.getPublicKey());
        String input = user.getRsaParams();
        // String sign = RSACrypt.sign(rsaParams);
        boolean verify = RSACrypt.verify(publicKey, input, user.getSign());
        //签名校验失败
        if (!verify) {
            signError(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        /*************************md5校验，避免抓包*****************************/
        //String token = generateMd5Token(user, sign);
        //String token = LoginSessionDao.generateMd5Token(user, sign);
        //url失效：说明已经使用过，避免抓包
        boolean exitToken = LoginSessionDao.exitToken(user, user.getSign());
        if (exitToken) {
            json.put(KEY_MSG, "该url已失效");
            json.put(KEY_CODE, CODE_URL_EXPIRED);
            writeJson(response, json);
            return;
        }
        //用户登录过，更新token
        boolean hasLogin = LoginSessionDao.hasLogin(user);
        String token = LoginSessionDao.generateMd5Token(user, user.getSign());
        if (hasLogin) {
            LoginSessionDao.update(UserDao.getInstance().getUserId(user.getUsername()), token);
            System.out.println("用户登录过，更新token");
        } else {
            System.out.println("用户没有登录过，插入token");
            //用户没有登录过，插入新的登录信息
            LoginSessionDao.insert(UserDao.getInstance().getUserId(user.getUsername()), token);
        }
        // 登录成功
        loginSuccess(response, json);
    }

    /**
     * 校验用户登录信息
     *
     * @param response
     * @param user
     * @param dao
     * @param json
     * @return
     */
    private void verifyLogin4(HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        if (TextUtils.isEmpty(user.getSign())) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        PublicKey publicKey = RSACrypt.getPublicKey(TimeSettingDao.getPublicKey());
        String input = user.getRsaParams();
        // String sign = RSACrypt.sign(rsaParams);
        boolean verify = RSACrypt.verify(publicKey, input, user.getSign());
        if (!verify) {
            json.put(KEY_MSG, "RSA签名校验失败");
            json.put(KEY_CODE, CODE_RSA_SIGN_ERROR);
            writeJson(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        // 登录成功
        loginSuccess(response, json);
    }

    /**
     * 校验用户登录信息
     *
     * @param response
     * @param user
     * @param dao
     * @param json
     * @return
     */
    private void verifyLogin5(HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        String sign = user.getSign();
        if (TextUtils.isEmpty(sign)) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        PublicKey publicKey = RSACrypt.getPublicKey(TimeSettingDao.getPublicKey());
        String input = user.getRsaParams();
        // String sign = RSACrypt.sign(rsaParams);
        boolean verify = RSACrypt.verify(publicKey, input, sign);
        //签名校验失败
        if (!verify) {
            signError(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        /*************************md5校验，避免抓包*****************************/
        //String token = generateMd5Token(user, sign);
        //String token = LoginSessionDao.generateMd5Token(user, sign);
        //url失效：说明已经使用过，避免抓包
        boolean exitToken = LoginSessionDao.exitToken(user, sign);
        if (exitToken) {
            json.put(KEY_MSG, "该url已失效");
            json.put(KEY_CODE, CODE_URL_EXPIRED);
            writeJson(response, json);
            return;
        }
        //用户登录过，更新token
        boolean hasLogin = LoginSessionDao.hasLogin(user);
        String token = LoginSessionDao.generateMd5Token(user, sign);
        if (hasLogin) {
            LoginSessionDao.update(UserDao.getInstance().getUserId(user.getUsername()), token);
            System.out.println("用户登录过，更新token");
        } else {
            System.out.println("用户没有登录过，插入token");
            //用户没有登录过，插入新的登录信息
            LoginSessionDao.insert(UserDao.getInstance().getUserId(user.getUsername()), token);
        }
        // 登录成功
        loginSuccess(response, json);
    }

    public void signError(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "RSA签名校验失败");
        json.put(KEY_CODE, CODE_RSA_SIGN_ERROR);
        writeJson(response, json);
    }


    public void missingSign(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "缺少参数sign");
        json.put(KEY_CODE, CODE_MISSING_SIGN);
        writeJson(response, json);
    }


    public void loginTimeout(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "登录超时" + TimeSettingDao.getLoginExpired() / 1000 + "秒");
        json.put(KEY_CODE, CODE_LOGIN_EXPIRED);
        json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        writeJson(response, json);
    }

    public void loginTimeMoreThanCurTime(HttpServletResponse response, JSONObject json, String loginTimestamp) {
        json.put(KEY_MSG, "timestamp值" + loginTimestamp + "不能大于当前时间" + TimeUtil.getCurTimestamp());
        json.put(KEY_CODE, CODE_PARAM_ERROR);
        json.put("info", "您已穿越到未来");
        writeJson(response, json);
    }

    public void missingTimestamp(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "缺少参数timestamp");
        json.put(KEY_CODE, CODE_PARAM_ERROR);
        writeJson(response, json);
    }

    public void loginSuccess(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "登录成功");
        json.put(KEY_CODE, CODE_SUCCESS);
        writeJson(response, json);
    }

    public void passwordNotCorrect(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "密码错误");
        json.put(KEY_CODE, CODE_PASSWORD_INCORRECT);
        writeJson(response, json);
    }

    public void usernameNotExit(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "用户名错误");
        json.put(KEY_CODE, CODE_USERNAME_INCORRECT);
        writeJson(response, json);
    }

    public void passwordIsEmpty(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "请输入密码");
        json.put(KEY_CODE, CODE_NOT_INPUT_PASSWORD);
        writeJson(response, json);
    }

    public void usernameIsEmpty(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "请输入用户名");
        json.put(KEY_CODE, CODE_NOT_INPUT_USER);
        writeJson(response, json);
    }

    public void remoteError(HttpServletResponse response, JSONObject json) {
        json.put(KEY_MSG, "服务器异常");
        json.put(KEY_CODE, CODE_REMOTE_ERROR);
        writeJson(response, json);
    }


    @Deprecated
    private void verifyLoginNew(HttpServletRequest request, HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        if (TextUtils.isEmpty(user.getSign())) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        String publicKeyStr = TimeSettingDao.getPublicKey();
        PublicKey publicKey = RSACrypt.getPublicKey(publicKeyStr);
        String input = appendSignParams(request);
        // String sign = RSACrypt.sign(rsaParams);
        String sign = request.getParameter("sign").replaceAll(" ", "+");
        boolean verify = RSACrypt.verify(publicKey, input, sign);
        if (!verify) {
            json.put(KEY_MSG, "RSA签名校验失败");
            json.put(KEY_CODE, CODE_RSA_SIGN_ERROR);
            writeJson(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        // 登录成功
        loginSuccess(response, json);
    }

    /**
     * 拼接RSA签名参数username=xxx&password=xxx&timestamp=xxx
     *
     * @param request
     * @return
     * @deprecated
     */
    private String appendSignParams(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String timestamp = request.getParameter("timestamp");
        stringBuilder.append("username=" + username + "&password=" + password + "" + "&timestamp=" + timestamp);
        return stringBuilder.toString();
    }


    @Deprecated
    private void verifyLoginNew1(HttpServletRequest request, HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        if (TextUtils.isEmpty(user.getSign())) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        String publicKeyStr = TimeSettingDao.getPublicKey();
        PublicKey publicKey = RSACrypt.getPublicKey(publicKeyStr);
        String input = appendSignParams1(request);
        // String sign = RSACrypt.sign(rsaParams);
        String sign = request.getParameter("sign").replaceAll(" ", "+");
        boolean verify = RSACrypt.verify(publicKey, input, sign);
        if (!verify) {
            signError(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        // 登录成功
        loginSuccess(response, json);
    }

    /**
     * 拼接RSA签名参数username=xxx&password=xxx&timestamp=xxx
     *
     * @param request
     * @return
     * @deprecated
     */
    private String appendSignParams1(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String timestamp = request.getParameter("timestamp");
        stringBuilder.append("username=" + username + "&password=" + password + "" + "&timestamp=" + timestamp);
        return stringBuilder.toString();
    }

    @Deprecated
    private void verifyLoginNew2(HttpServletRequest request, HttpServletResponse response, User user, UserDao dao, JSONObject json) {
        if (user == null) {
            remoteError(response, json);
            return;
        }
        // 没有输入用户名
        if (TextUtils.isEmpty(user.getUsername())) {
            usernameIsEmpty(response, json);
            return;
        }
        // 没有输入用户名密码
        if (TextUtils.isEmpty(user.getPassword())) {
            passwordIsEmpty(response, json);
            return;
        }
        // 没有传入sign参数
        if (TextUtils.isEmpty(user.getSign())) {
            missingSign(response, json);
            return;
        }
        // 校验签名是否正确
        // PrivateKey privateKey =
        // RSACrypt.getPrivateKey(TimeSettingDao.getPrivateKey());
        String publicKeyStr = TimeSettingDao.getPublicKey();
        PublicKey publicKey = RSACrypt.getPublicKey(publicKeyStr);
        String input = appendSignParams2(request);
        // String sign = RSACrypt.sign(rsaParams);
        String sign = request.getParameter("sign").replaceAll(" ", "+");
        boolean verify = RSACrypt.verify(publicKey, input, sign);
        if (!verify) {
            json.put(KEY_MSG, "RSA签名校验失败");
            json.put(KEY_CODE, CODE_RSA_SIGN_ERROR);
            writeJson(response, json);
            return;
        }
        String loginTimestamp = user.getTimestamp();
        // 缺少时间戳timestamp参数
        if (TextUtils.isEmpty(loginTimestamp)) {
            missingTimestamp(response, json);
            return;
        }
        // 登录时间大于当前时间：您已穿越
        if (Long.parseLong(loginTimestamp) > TimeUtil.getCurTimestamp()) {
            loginTimeMoreThanCurTime(response, json, loginTimestamp);
            return;
        }
        // 登录超时
        if (TimeUtil.getCurTimestamp() - Long.parseLong(loginTimestamp) > TimeSettingDao.getLoginExpired()) {
            loginTimeout(response, json);
            return;
        }
        // json.put(KEY_EXPIRED, TimeSettingDao.getLoginExpired());
        // 用户不存在
        if (!dao.exitUser(user)) {
            usernameNotExit(response, json);
            return;
        }
        // 密码错误
        if (!dao.verifyPassword(user)) {
            passwordNotCorrect(response, json);
            return;
        }
        // 登录成功
        loginSuccess(response, json);
    }

    /**
     * 拼接RSA签名参数username=xxx&password=xxx&timestamp=xxx
     *
     * @param request
     * @return
     * @deprecated
     */
    private String appendSignParams2(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String timestamp = request.getParameter("timestamp");
        stringBuilder.append("username=" + username + "&password=" + password + "" + "&timestamp=" + timestamp);
        return stringBuilder.toString();
    }


}
