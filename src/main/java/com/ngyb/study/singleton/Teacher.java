package com.ngyb.study.singleton;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:04
 */
public class Teacher {
    private static Teacher t;

    private Teacher() {

    }

    public synchronized static Teacher getInstance() {
        if (t == null) {
            t = new Teacher();
        }
        return t;
    }
}
