package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 11:27
 */
public class MyRunnable implements Runnable {
    private volatile boolean active;

    @Override
    public void run() {
        active = true;
        while (active) {

        }
    }

    public void stop() {
        active = false;
    }
}
