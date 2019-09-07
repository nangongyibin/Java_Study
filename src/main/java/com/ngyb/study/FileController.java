package com.ngyb.study;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/7 08:39
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping(value = "upload")
    public void uploadFile(HttpServletRequest request) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("file");
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String[] split = header.split(";");
        String file = split[split.length - 1];
        String[] filename = file.split("=");
        String str = filename[filename.length - 1];
        String fn = str.substring(1, str.length() - 1);
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
        System.out.println(fn);
        part.write(path+fn);
    }
}
