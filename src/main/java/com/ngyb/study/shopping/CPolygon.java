package com.ngyb.study.shopping;

public interface CPolygon {
    //展示商品
    void LayOutMerchandise();
    //反馈报价
    int FeedBackQuotation(int index);

    void shipments(CPolygon cPolygon);
    //咨询报价
    void CONSULTATIVE(CPolygon cPolygon,int index);
    //评估价格
    void EvaluateIt(CPolygon cPolygon,int price);
    //购买商品
    void buy(CPolygon cPolygon);
    //信息输出
    void OutPut(String values);
}
