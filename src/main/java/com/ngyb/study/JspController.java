package com.ngyb.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("index.jsp")
    public String index(){
        return "index";
    }
}
