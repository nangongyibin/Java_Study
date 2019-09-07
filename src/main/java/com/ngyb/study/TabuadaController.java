package com.ngyb.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/7 08:06
 */
@RestController
@RequestMapping("/tabuada")
public class TabuadaController {

    @GetMapping(value = "/get")
    public void getTabuada(HttpServletRequest request, HttpServletResponse response) {
        try {
            String num = request.getParameter("num");
            int numInt = Integer.parseInt(num);
            System.out.println(numInt + "");
            for (int j = 1; j <= numInt; j++) {
                for (int i = 1; i <= j; i++) {
                    response.getWriter().print(i + "*" + j + " = " + (i * j)+" ");
                }
                response.getWriter().println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
