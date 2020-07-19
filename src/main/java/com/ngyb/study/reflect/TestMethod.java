package com.ngyb.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 18:30
 */
public class TestMethod {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        method1();
//        method2();
//        method3();
//        method4();
        method5();
    }

    private static void method1() throws ClassNotFoundException {
        Class  cl = Class.forName("com.ngyb.study.reflect.Person");
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void method2() throws ClassNotFoundException {
        Class  cl = Class.forName("com.ngyb.study.reflect.Person");
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    public static void method3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class  cl = Class.forName("com.ngyb.study.reflect.Person");
        Method method = cl.getMethod("show");
        Constructor constructor = cl.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object);
    }

    public static void method4() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class  cl = Class.forName("com.ngyb.study.reflect.Person");
        Method method = cl.getMethod("show2",String.class);
        Constructor constructor = cl.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object,"nangongyibin@gmail.com");
    }

    public static void method5() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class  cl = Class.forName("com.ngyb.study.reflect.Person");
        Method method = cl.getDeclaredMethod("function");
        Constructor constructor = cl.getConstructor();
        Object object = constructor.newInstance();
        method.setAccessible(true);
        method.invoke(object);
    }
}
