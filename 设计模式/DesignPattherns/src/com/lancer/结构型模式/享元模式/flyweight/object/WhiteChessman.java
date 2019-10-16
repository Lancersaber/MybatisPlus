package com.lancer.结构型模式.享元模式.flyweight.object;

public class WhiteChessman extends AbstractChessman {

    public WhiteChessman(String chess) {
        super(chess);
    }

    public WhiteChessman(){
        super("W");
        System.out.println("--WhiteChessman Construction Exec!!!");
    }
}
