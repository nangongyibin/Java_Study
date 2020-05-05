package com.ngyb.study.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 网络请求相关
 */
public class NetWork {

    /**
     * 解析服务器请求参数
     *
     * @param request
     * @return
     */
    public static String parserRequest(HttpServletRequest request) {
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
        try {
            for (Map.Entry<String, String> me : params.entrySet()) {
                json.put(me.getKey(), me.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
