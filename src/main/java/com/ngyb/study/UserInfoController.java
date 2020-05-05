package com.ngyb.study;

import com.alibaba.fastjson.JSON;
import com.ngyb.study.bean.User;
import com.ngyb.study.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/5/5 20:17
 */
@RestController
@RequestMapping(value = "UserInfoController")
public class UserInfoController extends BaseController {
    @RequestMapping(value = "usersInfo", method = RequestMethod.GET)
    public void userinfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(CHARACTE);
        List<User> list = UserDao.getInstance().getAllUsers();
        String jsonList = JSON.toJSONString(list);
        response.getWriter().write(jsonList);
    }
}
