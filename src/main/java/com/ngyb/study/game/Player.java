package com.ngyb.study.game;

import java.util.Random;

public class Player {
    private int HP = 100;
    private String playerName;


    public void talk(Computer computer) {
        System.out.println(Output.player + "瞅你咋的，我还想打死你了");
        combat(computer);
    }

    public void combat(Computer computer) {
        computer.Injured(this);
    }

    public void Injured(Computer computer) {
        Random random = new Random();
        int harm = random.nextInt(6);
        if (harm ==0){
            System.out.println(Output.player+"我身轻如燕，哈哈哈，你打不到我");
            combat(computer);
        }else{
            HP-=harm;
            if (HP<=0){
                HP = 0;
                System.out.println(Output.player+"哎呀，好疼，伤害："+harm+"      血量："+HP);
                System.out.println("恭喜，"+Output.computer+"胜！！！！！！");
            }else{
                System.out.println(Output.player+"哎呀，好疼，伤害："+harm+"      血量："+HP);
                combat(computer);
            }
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHP() {
        return HP;
    }
}
