package com.lancer.结构型模式.享元模式.flyweight.object2;

public abstract class AbstractChessman {

    //棋子坐标
    protected int x;
    protected int y;

    //棋子类别(黑|白)
    protected String chess;

    //构造方法注入棋子类别
    public AbstractChessman(String chess){
        this.chess=chess;
    }

    //点坐标设置
    public abstract void paint(int x,int y);

    //显示棋子信息
    public void show(){
        System.out.println(this.chess+"("+this.x+","+this.y+")");
    }
}
