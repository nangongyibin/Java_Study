package com.ngyb.study.decorate;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:54
 */
public class RingFunction extends BasicFunction {
    public RingFunction(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        System.out.println("手机可以响铃了。。。。。。");
        super.call();
    }
}
