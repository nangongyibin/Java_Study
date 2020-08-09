package com.ngyb.study.test.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 14:56
 */
public class POJOToJson {
    public static void main(String[] args) {
        //组装数据
        Result result = new Result();
        result.setResultCode("0");
        result.setResultMessage("操作成功");
        result.setPage("1");
        result.setSize("10");
        result.setTotal_result("3");
        result.setTotal_pages("1");
        result.setStart_time("2020/8/9 14:56");
        result.setEnd_time("2020/8/9 14:56");
        List<PersonInfo> staff = new ArrayList<>();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonalID("220172197901121515");
        personInfo.setInnerID("010001");
        personInfo.setName("王磊");
        personInfo.setDepartment("检定");
        personInfo.setDepCode("20");
        personInfo.setCreatetime("2020/8/9 14:56");
        personInfo.setOpr_type("add");
        staff.add(personInfo);
        result.setStaff(staff);
        //创建json解析
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(result);
        System.out.println("json:" + json);
    }
}
