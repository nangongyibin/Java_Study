package com.ngyb.study.shopping;

public class Boss2 extends BaseInfo {
    public String[] goods = {"风扇", "插板", "鼠标", "音响", "书"};
    public int[] prices = {1, 2, 3, 4, 5};

    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
    }

    public int[] getPrices() {
        return prices;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public void LayOutMerchandise() {
        OutPut("卖家展示商品：\n");
        OutPut("风扇，插板，鼠标，音响，书");
    }

    public int FeedBackQuotation(int index) {
        return prices[index];
    }

    public void shipments(CPolygon cPolygon) {
        OutPut("卖家发货了");
    }

    public void CONSULTATIVE(CPolygon cPolygon, int index) {

    }

    public void EvaluateIt(CPolygon cPolygon, int price) {

    }

    public void buy(CPolygon cPolygon) {

    }
}
