package com.ngyb.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/13 17:36
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "loginServlet",method = {RequestMethod.GET,RequestMethod.POST})
    public void login(HttpServletRequest request, HttpServletResponse response){
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("abc")&& password.equals("123")){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("failure");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
