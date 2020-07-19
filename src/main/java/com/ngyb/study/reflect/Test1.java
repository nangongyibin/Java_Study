package com.ngyb.study.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 17:43
 */
public class Test1 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<String> lists = new ArrayList<>();
        lists.add("kkk");
        Class clazz = lists.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(lists,1);
        System.out.println(lists);
    }
}
