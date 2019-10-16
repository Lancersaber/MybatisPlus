package com.lancer.结构型模式.享元模式.flyweight.object;

public class BlackChessman extends AbstractChessman {
    //初始方法，初始化黑棋子
    public BlackChessman(String chess) {
        super(chess);
    }

    public BlackChessman(){
        super("B");
        System.out.println("--BlackChessman Construction Exec!!!");
    }
}
