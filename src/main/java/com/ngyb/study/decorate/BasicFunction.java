package com.ngyb.study.decorate;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:53
 */
public abstract class BasicFunction implements Phone{
    private Phone p;

    public BasicFunction(Phone p) {
        this.p = p;
    }

    @Override
    public void call() {
        p.call();
    }
}
