package com.ngyb.study;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/5/5 19:59
 */
public class BaseController extends HttpServlet {
    protected static String CHARACTE = "utf-8";

    /**
     * 返回json
     *
     * @param response
     * @param json
     */
    protected void writeJson(HttpServletResponse response, JSONObject json) {
        try {
            PrintWriter writer = response.getWriter();
            writer.write(json.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setCharacte(HttpServletResponse response) {
        response.setCharacterEncoding(CHARACTE);
    }

    protected String parserRequest(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        JSONObject json = new JSONObject();// 存储json到数据库
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"),
            // "utf-8");
            params.put(name, valueStr);
            try {
                //json.put(name, valueStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, String> me : params.entrySet()) {
            json.put(me.getKey(), me.getValue());
        }
        return json.toString();
    }

    /**
     * Fastjson将请求参数转成Bean对象
     *
     * @param request
     * @param clazz
     * @return
     */
    protected <T> T parserRequest(HttpServletRequest request, Class<T> clazz) {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        JSONObject json = new JSONObject();// 存储json到数据库
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"),
            // "utf-8");
            params.put(name, valueStr);
            try {
                //json.put(name, valueStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, String> me : params.entrySet()) {
            json.put(me.getKey(), me.getValue());
        }
        //return json.toString();
        return JSONObject.parseObject(json.toJSONString(), clazz);
    }
}
