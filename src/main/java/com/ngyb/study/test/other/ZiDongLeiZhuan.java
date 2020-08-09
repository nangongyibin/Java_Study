package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:18
 */
public class ZiDongLeiZhuan {

    public static void main(String[] args) {
        char c1 = 'a';//定义一个char类型
        int i1 = c1;// char自动类型转换为int
        System.out.println("char自动类型转换为int后的值等于"+i1);

        char c2 = 'A';//定义一个char类型
        int i2 = c2+1;// char类型和int类型计算
        System.out.println("char类型和int类型计算后的值等于"+i2);
    }
}
