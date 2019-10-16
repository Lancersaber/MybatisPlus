package com.lancer.创建型模式.抽象工厂模式;

import com.lancer.创建型模式.抽象工厂模式.abstractClass.*;

public class Customer {

    //抽象工厂
    private IKfcFactory kfcFactory;

    //构造方法将抽象工厂作为参数传入
    public Customer(IKfcFactory kfcFactory){
        this.kfcFactory=kfcFactory;
    }

    //订购麻辣鸡腿汉堡
    public float orderHamburg(int num){

        //获得麻辣鸡腿汉堡
        Hamburg hamburg=kfcFactory.createHamBurg(num);
        //输出订购信息
        hamburg.printMessage();
        //返回总价
        return hamburg.totolPrice();
    }

    //订购奥尔良烤鸡翅
    public float orderChickenWings(int num){
        //获得奥尔良烤鸡翅
        ChickenWings chickenWings=kfcFactory.createChickenWings(num);
        //输出订购信息
        chickenWings.printMessage();
        //返回总价
        return chickenWings.totolPrice();
    }

    //订购薯条
    public float orderFrenchFries(int num){
        //获得薯条
        FrenchFries frenchFries=kfcFactory.createFrenchFries(num);
        //输出订购信息
        frenchFries.printMessage();
        //返回总价
        return frenchFries.totolPrice();
    }

    //订购可乐
    public float orderBeverage(int num){
        //获得可乐
        Beverage beverage=kfcFactory.createBeverage(num);
        //输出订单信息
        beverage.printMessage();
        //返回总价
        return beverage.totolPrice();
    }

}
