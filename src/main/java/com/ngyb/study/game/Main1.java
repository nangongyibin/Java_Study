package com.ngyb.study.game;

public class Main1 {
    public static void main(String[] args){
        Computer1 computer1 = new Computer1();
        Player1 player1 = new Player1();
        player1.setBlood(100);
        computer1.setBlood(100);
        player1.setName("玩家一");
        computer1.setName("电脑一");
        computer1.talk(player1);
        Output1.Output(player1,computer1);
    }
}
