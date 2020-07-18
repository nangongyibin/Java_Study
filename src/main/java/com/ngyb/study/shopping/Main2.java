package com.ngyb.study.shopping;

public class Main2 {

    public static void main(String[] args){
        Boss2 boss = new Boss2();
        Buyer2 buyer = new Buyer2();
        buyer.setMoney(5);
        boss.LayOutMerchandise();
        buyer.CONSULTATIVE(boss,0);
    }
}
