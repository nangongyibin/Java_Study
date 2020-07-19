package com.ngyb.study.note;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 19:32
 */
@Note(testInt = 1,testStr="haha",testClass=dog.class,testEnum=TrafficLapm.green,testAnno=@Note2,testArr={"222"})
public class Anim {
    @Deprecated
    public void chi(){

    }

    public void eat(){
        System.out.println("hhh");
    }
}
