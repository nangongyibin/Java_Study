package com.ngyb.study.decorate;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:55
 */
public class Test {

    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        MusicFunction musicFunction = new MusicFunction(iphone);
        musicFunction.call();
        RingFunction ringFunction = new RingFunction(iphone);
        ringFunction.call();
    }
}
