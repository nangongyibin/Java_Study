package com.ngyb.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 18:22
 */
public class TestConstructorMethod {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        method1();
//        method2();
//        method3();
//        method4();
        method5();
    }

    private static void method1() throws ClassNotFoundException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method2() throws ClassNotFoundException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method3() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Constructor  constructor  = cl.getConstructor();
        Object object = constructor.newInstance();
        System.out.println(object);
    }

    private static void method4() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Constructor  constructor  = cl.getConstructor(String.class,int.class,String.class);
        Object object = constructor.newInstance("南宫燚滨",23,"nangongyibin@gmail.com");
        System.out.println(object);
    }

    private static void method5() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class cl = Class.forName("com.ngyb.study.reflect.Person");
        Constructor  constructor  = cl.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Object object = constructor.newInstance("南宫燚滨");
        System.out.println(object);
    }
}
