package com.lancer.创建型模式.抽象工厂模式.abstractClass;

public interface IKfcFactory {

    //生产汉堡
    public Hamburg createHamBurg(int num);

    //生产薯条
    public FrenchFries createFrenchFries(int num);

    //生产鸡翅
    public ChickenWings createChickenWings(int num);

    //生产饮料
    public Beverage createBeverage(int num);

}
