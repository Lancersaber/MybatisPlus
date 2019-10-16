package com.lancer.创建型模式.抽象工厂模式.abstractClass;

/**
 * 食物基类
 */
public abstract class AbstractBaseFood {

    //类别
    protected String kind;
    //数量
    protected int num;
    //价格
    protected float price;

    public float totolPrice(){
        return this.num*this.price;
    }
}
