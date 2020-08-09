package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:09
 */
public class RegExpTest {

    public static void main(String[] args) {
        String phone = "0358-3458576";
        System.out.println(isPhone(phone));
    }

    public static boolean isPhone(String phone) {
        //String reg = "(^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?))$|(^1(3|4|5|7|8)\\d{9})";
        String reg = "(^0\\d{2,3}-\\d{7,8})|(^1(3|4|5|7|8)\\d{9})";
        return phone.matches(reg);
    }
}
