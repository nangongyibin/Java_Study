package com.ngyb.study.game;

import java.util.Random;

public class Computer {
    private int HP = 100;
    private String computerName;

    public void talk(Player player){
        System.out.println(Output.computer+"小子，你瞅啥");
        player.talk(this);
    }

    public void Injured(Player player){
        Random random = new Random();
        int harm = random.nextInt(6);
        if (harm ==0){
            System.out.println(Output.computer+"我身轻如燕，哈哈哈，你打不到我");
            combat(player);
        }else{
            HP-=harm;
            if (HP<=0){
                HP = 0;
                System.out.println(Output.computer+"哎呀，好疼，伤害："+harm+"      血量："+HP);
                System.out.println("恭喜，"+Output.player+"胜！！！！！！");
            }else{
                System.out.println(Output.computer+"哎呀，好疼，伤害："+harm+"      血量："+HP);
                combat(player);
            }
        }
    }

    private void combat(Player player) {
        player.Injured(this);
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public int getHP() {
        return HP;
    }
}
