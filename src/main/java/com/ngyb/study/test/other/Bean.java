package com.ngyb.study.test.other;

public class Bean {
    int value = 10;
    public static final int BOXWIDTH = 6;
    static final String TITLE = "Manager";

    public final void changeValue(){
        value = 12;
    }

    public void pupAge(){
        int age = 0;
        age = age +7;
        System.out.println("小狗的年龄是："+age);
    }

    public static void main(String[] args){
        Bean bean = new Bean();
        bean.pupAge();
    }
}
