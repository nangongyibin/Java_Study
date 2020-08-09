package com.ngyb.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 21:56
 */
@Controller
public class IndexController {

//    @RequestMapping("/{view}")
//    public String html(@PathVariable("view")String view){
//        return view;
//    }

    @RequestMapping("/index")
    public String indexOne() {
        return "indexOne";
    }

    @RequestMapping("/")
    public String indexTwo() {
        return "index";
    }
}
