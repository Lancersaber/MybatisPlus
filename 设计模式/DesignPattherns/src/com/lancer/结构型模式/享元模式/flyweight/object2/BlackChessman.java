package com.lancer.结构型模式.享元模式.flyweight.object2;

public class BlackChessman extends AbstractChessman {

    public BlackChessman() {
        super("黑棋");
        System.out.println("--黑棋构造方法执行");
    }

    @Override
    public void paint(int x, int y) {
        this.x=x;
        this.y=y;
        this.show();
    }
}
