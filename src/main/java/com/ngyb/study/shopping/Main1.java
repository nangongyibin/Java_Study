package com.ngyb.study.shopping;

public class Main1 {

    public static void main(String[] args){
        Boss1 boss = new Boss1();
        Buyer1 buyer = new Buyer1();
        buyer.setMoney(2);
        boss.LayOutMerchandise();
        buyer.CONSULTATIVE(boss,4);
    }
}
