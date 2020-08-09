package com.ngyb.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ReverseController {
    Logger logger = LoggerFactory.getLogger(ReverseController.class);

    @RequestMapping(value = "reverse", method = {RequestMethod.GET, RequestMethod.POST})
    public void reverse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("---------");
        //解决乱码
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        logger.info(name);
        request.getRequestDispatcher("").forward(request, response);
    }
}
