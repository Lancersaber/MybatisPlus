package com.lancer.创建型模式.抽象工厂模式.concreate;

import com.lancer.创建型模式.抽象工厂模式.abstractClass.FrenchFries;

public class ChinaFrenchFries extends FrenchFries {

    public ChinaFrenchFries(int num){
        this.kind="普通";
        this.price=8.0f;
        this.num=num;
    }
}
