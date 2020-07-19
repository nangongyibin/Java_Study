package com.ngyb.study.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 20:40
 */
public class parseJsonTest {

    @Test
    public void parseJsonTest1() throws JSONException {
        String testjson = "{name:'nangongyibin',age:'18',sex:'nv'}";
        JSONObject json = new JSONObject(testjson);
        String name = (String) json.get("name");
        System.out.println(name);
    }

    @Test
    public void parseJsonTest2() throws JSONException {
        String testjson = "[{name:'nangongyibin',age:'18',sex:'nv'},{name:'nangongyibin',age:'18',sex:'nv'}]";
        JSONArray json = new JSONArray(testjson);
        JSONObject ob = (JSONObject) json.get(1);
        String name = (String) ob.get("name");
        System.out.println(name);
    }
}
