package com.ngyb.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 21:32
 */
@RestController
@RequestMapping(value = "/ServletController")
public class ServletController {

    @RequestMapping(value = "form", method = {RequestMethod.GET, RequestMethod.POST})
    public void form(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getMethod();
        System.out.println(method);
        String name = request.getParameter("name");
        String encode = URLEncoder.encode(name, "iso-8859-1");
        System.out.println("++++"+encode);
        String decode = URLDecoder.decode("encode", "utf-8");
        System.out.println("===="+decode);
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        System.out.println(pwd+"====="+sex);
        String[] fruits = request.getParameterValues("fruit");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        response.setHeader("content-type","text/html;charset=utf-8");
        response.getOutputStream().write("登录成功".getBytes("utf-8"));
    }
}
