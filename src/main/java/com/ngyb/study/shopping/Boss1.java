package com.ngyb.study.shopping;

public class Boss1 {
    public String[] goods = {"风扇", "插板", "鼠标", "音响", "书"};
    public int[] prices = {1, 2, 3, 4, 5};

    public void LayOutMerchandise() {
        System.out.println("卖家展示商品：\n");
        System.out.println("风扇，插板，鼠标，音响，书");
    }

    public int FeedBackQuotation(int index) {
        return prices[index];
    }

    public void shipments(Buyer1 buyer) {
        System.out.println("卖家发货了");
    }
}
