package com.ngyb.study.shopping;

public class Buyer1{
    int money;

    public void CONSULTATIVE(Boss1 boss, int index) {
        int price = boss.FeedBackQuotation(index);
        EvaluateIt(boss,price);
    }

    public void EvaluateIt(Boss1 boss, int price) {
        if (price > money){
            System.out.println("商品太贵了，买不起");
        }else{
            buy(boss);
        }
    }

    public void buy(Boss1 boss) {
        boss.shipments(this);
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
