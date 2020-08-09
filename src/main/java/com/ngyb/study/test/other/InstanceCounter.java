package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 10:15
 */
public class InstanceCounter {
    private static int numInstances = 0;

    protected  static int getCount(){
        return numInstances;
    }

    private static void addInstance(){
        numInstances++;
    }

    InstanceCounter(){
        InstanceCounter.addInstance();
    }

    public static void main(String[] args){
        System.out.println("starting width "+InstanceCounter.getCount()+" instances");
        for (int i = 0; i < 500; i++) {
            new InstanceCounter();
        }
        System.out.println("created "+InstanceCounter.getCount()+" instances");
    }
}
