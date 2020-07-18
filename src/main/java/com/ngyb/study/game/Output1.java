package com.ngyb.study.game;

public class Output1 {
    public static final String computer = "玩家一";
    public static final String player = "玩家二";
    public static final String tieku = "==============================================================================";

    public static void Output(CPolygon player,CPolygon computer){
        System.out.println(tieku);
        System.out.println(((Player1)player).getName()+"                           "+((Computer1)computer).getName());
        System.out.println(((Player1)player).getBlood()+"           血量                "+((Computer1)computer).getBlood());
        System.out.println(tieku);
    }
}
