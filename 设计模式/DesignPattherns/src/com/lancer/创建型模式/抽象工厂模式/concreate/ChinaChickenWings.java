package com.lancer.创建型模式.抽象工厂模式.concreate;

import com.lancer.创建型模式.抽象工厂模式.abstractClass.ChickenWings;

public class ChinaChickenWings extends ChickenWings {

    public ChinaChickenWings(int num){
        this.kind="奥尔良";
        this.price=2.5f;
        this.num=num;
    }
}
