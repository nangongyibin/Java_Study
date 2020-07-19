package com.ngyb.study.template;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:26
 */
public abstract class CountTime {

    public abstract void code();

    public Long getCodeTime() {
        Long startTime = System.currentTimeMillis();
        code();
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
