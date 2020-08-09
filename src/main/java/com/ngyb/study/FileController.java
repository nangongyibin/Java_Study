package com.ngyb.study;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/7 08:39
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {

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
        part.write(path + fn);
    }

    @RequestMapping(value = "download")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
            //path是指下载的文件的路径
            String path = "download.txt";
            File file = new File(path);
            //取得文件名
            String fileName = file.getName();
            //以流的形式下载文件
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            //清空response
            response.reset();
            //设置response的Header
            //设置文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            //设置文件打下
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "uploadNew")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, ServletException, IOException {
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String realPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(realPath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(realPath + "目录不存在，需要创建");
            //创建目录
            file.mkdirs();
        }
        //消息提示
        String message = "";
        try {
            //1.apache的核心API：DiskFileItemFactory
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2.apache的核心API：ServletFileUpload ,负责处理上传的文件数据
            ServletFileUpload upload = new ServletFileUpload(factory);
            //2.2设置编码格式
            upload.setHeaderEncoding("UTF-8");
            //判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return;
            }
            List<FileItem> fileItems = upload.parseRequest(request);
            for (Iterator iter = fileItems.iterator(); iter.hasNext(); ) {
                //3.apache的核心API:FileItem
                FileItem item = (FileItem) iter.next();
                //3.1是普通的表单输入域
                if (item.isFormField()) {
                    //
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");
                    System.out.println(name + "====" + value);
                } else {
                    //3.2获取文件名，IE为绝对路径，Firefox只有文件名
                    String fileName = item.getName();
                    //3.3获得上传文件的大小
                    long size = item.getSize();
                    if ((fileName == null || fileName.equals("")) && size == 0) {
                        continue;
                    }
                    //截取字符串 ，获得文件名
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(realPath + "\\" + fileName);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    message = "文件上传成功！";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "文件上传失败！";
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("/message").forward(request,response);
    }
}
