package com.ngyb.study.game;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        computer.setComputerName("玩家一");
        player.setPlayerName("玩家二");
        computer.talk(player);
        Output.Output(computer, player);
    }
}
