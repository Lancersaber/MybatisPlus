package com.lancer.结构型模式.享元模式.flyweight.object;

public abstract class AbstractChessman {

    //棋子类别(黑|白)
    protected String chess;

    public AbstractChessman (String chess){
        this.chess=chess;
    }

    //显示棋子信息
    public void show(){
        System.out.println(this.chess);
    }
}
