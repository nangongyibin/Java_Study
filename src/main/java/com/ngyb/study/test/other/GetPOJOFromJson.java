package com.ngyb.study.test.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 10:04
 */
public class GetPOJOFromJson {

    public static void main(String[] args){
        Gson gson = new GsonBuilder().create();
        String json = "{\"resultCode\":\"0\",\"resultMessage\":\"操作成功\",\"page\":\"1\",\"size\":\"10\",\"total_result\":\"3\",\"total_Pages\":\"1\",\"start_time\":\"2018-1-4 15:30:12\",\"end_time\":\"2018-10-4 08:10:56\",\"staff\":[{\"personalID\":\"220172197901121515\",\"innerID\":\"010001\",\"name\":\"王磊\",\"department\":\"检定\",\"depCode\":\"20\",\"createtime\":\"2018-03-10 13:21:00\",\"opr_type\":\"add\"},{\"personalID\":\"125172198812241515\",\"innerID\":\"010010\",\"name\":\"张三\",\"department\":\"20\",\"depCode\":\"检定\",\"createtime\":\"\",\"opr_type\":\"\"},{\"personalID\":\"\",\"innerID\":\"\",\"name\":\"\",\"department\":\"\",\"depCode\":\"\",\"createtime\":\"\",\"opr_type\":\"\"}]}";
        Result result = gson.fromJson(json,Result.class);
        System.out.println(result.getResultCode());
        System.out.println(result.getResultMessage());
    }
}
