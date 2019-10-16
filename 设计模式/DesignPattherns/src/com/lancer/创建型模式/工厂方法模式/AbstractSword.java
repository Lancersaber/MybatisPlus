package com.lancer.创建型模式.工厂方法模式;

public class AbstractSword {

    //宝刀的名称
    private String name;

    //抽象父类的构造方法
    public AbstractSword(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
