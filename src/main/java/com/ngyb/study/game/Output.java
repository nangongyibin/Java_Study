package com.ngyb.study.game;

public class Output {
    public static final String computer = "玩家一";
    public static final String player = "玩家二";
    public static final String tieku = "==============================================================================";

    public static void Output(Computer computer,Player player){
        System.out.println(player.getPlayerName()+"                           "+computer.getComputerName());
        System.out.println(player.getHP()+"                           "+computer.getHP());
    }
}
