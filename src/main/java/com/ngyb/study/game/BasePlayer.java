package com.ngyb.study.game;

import java.util.Random;

public abstract class BasePlayer<T> implements CPolygon {
    public String name;
    public int blood;
    public int harm;

    public int createAttackInfo(){
        Random random = new Random();
        return random.nextInt(6);
    }

    public void bloodChange(){
        blood -=harm;
    }

    public void createInfo(T values){
        System.out.println(values);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }
}
