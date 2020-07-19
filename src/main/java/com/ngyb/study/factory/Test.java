package com.ngyb.study.factory;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:18
 */
public class Test {

    public static void main(String[] args) {
        Anim cat = AnimFactory.getAnim("cat");
        cat.eat();
    }
}
