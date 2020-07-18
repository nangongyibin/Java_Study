package com.ngyb.study.test;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/18 22:50
 */
public class VariableParameter {

    public static void main(String[] args) {
        int count = add(1, 2, 3, 4);
        System.out.println(count);
    }

    private static int add(int i, int... j) {
        int sum = i;
        for (int k = 0; k < j.length; k++) {
            sum += j[k];
        }
        return sum;
    }
}
