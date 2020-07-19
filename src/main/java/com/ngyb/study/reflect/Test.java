package com.ngyb.study.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 17:32
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("use.properties"));
        String className = (String) properties.get("className");
        String methodName = (String) properties.get("methodName");
        System.out.println(methodName);
        Class  cl = Class.forName(className);
        Constructor constructor = cl.getConstructor();
        Object obj = constructor.newInstance();
        Method method = cl.getMethod(methodName);
        method.invoke(obj);
    }
}
