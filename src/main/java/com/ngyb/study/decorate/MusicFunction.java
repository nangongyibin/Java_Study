package com.ngyb.study.decorate;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:53
 */
public class MusicFunction extends BasicFunction{
    public MusicFunction(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("手机可以听歌了！！！！！！");
    }
}
