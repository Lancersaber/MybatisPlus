package com.lancer.创建型模式.抽象工厂模式.concreate;

import com.lancer.创建型模式.抽象工厂模式.abstractClass.Beverage;

public class ChinaBeverage extends Beverage {

    public ChinaBeverage(int num){
        this.kind="可乐";
        this.price=7.0f;
        this.num=num;
    }
}
