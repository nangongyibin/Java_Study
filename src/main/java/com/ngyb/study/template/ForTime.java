package com.ngyb.study.template;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:28
 */
public class ForTime {

    public static void main(String[] args) {
        CountTime countTime = new CountTime() {
            @Override
            public void code() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        };
        Long time = countTime.getCodeTime();
        System.out.println("         "+time);
    }
}
