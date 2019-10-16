package com.lancer.结构型模式.享元模式.flyweight.object2;

public class WhiteChessman extends AbstractChessman{


    public WhiteChessman() {
        super("白棋");
        System.out.println("白棋的构造方法执行...");
    }

    @Override
    public void paint(int x, int y) {
        this.x=x;
        this.y=y;
        this.show();
    }
}
