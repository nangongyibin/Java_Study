package com.ngyb.study.shopping;

public class Buyer2 extends BaseInfo{
    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void LayOutMerchandise() {

    }

    public int FeedBackQuotation(int index) {
        return 0;
    }

    public void shipments(CPolygon cPolygon) {

    }

    public void CONSULTATIVE(CPolygon cPolygon, int index) {
        int price = ((Boss2) cPolygon).FeedBackQuotation(index);
        EvaluateIt((Boss2)cPolygon,price);
    }

    public void EvaluateIt(CPolygon cPolygon, int price) {
        if (price > money){
            System.out.println("商品太贵了，买不起");
        }else{
            buy((Boss2)cPolygon);
        }
    }

    public void buy(CPolygon cPolygon) {
        ((Boss2)cPolygon).shipments(this);
    }
}
