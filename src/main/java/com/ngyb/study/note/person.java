package com.ngyb.study.note;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 19:37
 */
public class person {
    @Override
    public String toString() {
        return "person{}";
    }
    @myTest
    public void eat(){
        System.out.println("吃饭");
    }

    @myTest
    public void sleep(){
        System.out.println("睡觉");
    }

    @myTest
    public void BeatBeansForiPad(){
        System.out.println("打英雄联盟");
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface myTest{

    }
}
