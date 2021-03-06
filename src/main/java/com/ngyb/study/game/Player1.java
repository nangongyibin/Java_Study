package com.ngyb.study.game;

public class Player1 extends BasePlayer<String>{
    @Override
    public void talk(CPolygon cPolygon) {
        createInfo(getName()+"瞅你咋的，我还想打死你了");
        combat((Computer1)cPolygon);
    }

    @Override
    public void combat(CPolygon cPolygon) {
        ((Computer1)cPolygon).Injured(this);
    }

    @Override
    public void Injured(CPolygon cPolygon) {
        harm = createAttackInfo();
        if (harm ==0){
            createInfo(getName()+"我身轻如燕，哈哈哈，你打不到我");
            combat((Computer1)cPolygon);
        }else{
            bloodChange();
            if (getBlood()<=0){
                setBlood(0);
                createInfo(getName()+"哎呀，好疼，伤害："+harm+"      血量："+getBlood());
               createInfo("恭喜，"+((Computer1)cPolygon).getName()+"胜！！！！！！");
            }else{
                createInfo(getName()+"哎呀，好疼，伤害："+harm+"      血量："+getBlood());
                combat((Computer1)cPolygon);
            }
        }
    }
}
