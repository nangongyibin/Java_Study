package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 11:40
 */
public class Number {
    public static void main(String[] args) {
        System.out.println(isNumber("aa"));
        System.out.println(isNumber("-11.2"));
    }

    public static boolean isNumber(String number) {
        //String regex = "^[-+]?\\d+(\\.\\d+)?$";
        String regex = "^[0.0-9.0]+$";
        if (number != null && !number.equals("")) {
            return number.matches(regex);
//            if (number.length()==1&&(number.equals("-")||number.equals("+"))){
//                return false;
//            }else{
//
//            }
        } else {
            return false;
        }

    }
}
