package com.ngyb.study.reflect;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 17:48
 */
public class Person {
    private String name;
    private int age;
    public String address;

    public Person(){

    }

    private Person(String name){
        this.name = name;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show(){
        System.out.println("show");
    }

    public void show2(String s){
        System.out.println("show2："+s);
    }

    public String getStr(String s,int i){
        System.out.println("~~~~s:"+s+"~~~~i:"+i);
        return s+"~~~~"+i;
    }

    private void function(){
        System.out.println("function");
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    public void BeatBeansforiPad(){
        System.out.println("打英雄联盟");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
