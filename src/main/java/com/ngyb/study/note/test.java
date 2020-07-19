package com.ngyb.study.note;

import com.ngyb.study.reflect.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 19:37
 */
@Note3({"all"})
public class test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cl = Person.class;
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            boolean flag = method.isAnnotationPresent(person.myTest.class);
            System.out.println(flag);
            if (flag){
                Constructor constructor = cl.getConstructor();
                Object object = constructor.newInstance();
                method.invoke(object);
            }
        }
    }
}
