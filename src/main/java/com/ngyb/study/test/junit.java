package com.ngyb.study.test;

import com.ngyb.study.reflect.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 19:11
 */
public class junit {
    private Person p;
    @Before
    public void before(){
        System.out.println("执行前");
        p = new Person();
    }

    @Test
    public void middle(){
        p.eat();
        p.sleep();
        p.BeatBeansforiPad();
    }

    @After
    public void after(){
        System.out.println("执行后");
        p = null;
    }
}
