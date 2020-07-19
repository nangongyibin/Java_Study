package com.ngyb.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 17:58
 */
public class TestAttribute {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
//        method1();
//        method2();
//        method3();
        method4();
    }

    private static void method1() throws ClassNotFoundException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void method2() throws ClassNotFoundException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    public static void method3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Constructor constructor = cl.getConstructor();
        Object object = constructor.newInstance();
        Field field = cl.getField("address");
        field.set(object,"nangongyibin@gmail.com");
        System.out.println(object);
    }

    public static void method4() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Field field = cl.getDeclaredField("age");
        System.out.println(field);
        field.setAccessible(true);
        Constructor constructor = cl.getConstructor();
        Object object = constructor.newInstance();
        field.set(object,23);
        System.out.println(object);
    }
}
