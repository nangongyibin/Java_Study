package com.ngyb.study;

import com.alibaba.fastjson.JSONObject;
import com.ngyb.study.bean.User;
import com.ngyb.study.dao.UserDao;
import com.ngyb.study.constant.Constants;
import com.ngyb.study.utils.NetWork;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/5/5 19:39
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterController extends BaseController{


    @RequestMapping(value = "userRegister", method = RequestMethod.GET)
    public void register(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding(CHARACTE);
        String parser = NetWork.parserRequest(request);
        System.out.println(parser);
        User user = JSONObject.parseObject(parser, User.class);
        UserDao userDao = UserDao.getInstance();
        JSONObject json = new JSONObject();
        if (userDao.exitUser(user.getUsername())) {
            json.put("msg", "注册失败,用户名已存在");
            json.put("code", Constants.CODE_REGISTER_FAILED);
        } else {
            boolean register = userDao.registerUser(user.getUsername(), user.getPassword());
            json.put("msg", register ? "注册成功" : "注册失败");
            json.put("code", register ? Constants.CODE_SUCCESS : Constants.CODE_REGISTER_FAILED);
        }
        writeJson(response, json);
    }
}
