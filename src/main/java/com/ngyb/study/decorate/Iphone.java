package com.ngyb.study.decorate;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:52
 */
public class Iphone  implements Phone{
    @Override
    public void call() {
        System.out.println("电话可以通话了");
    }
}
