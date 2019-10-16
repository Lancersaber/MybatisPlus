package com.lancer.创建型模式.抽象工厂模式.concreate;

import com.lancer.创建型模式.抽象工厂模式.abstractClass.*;

/**
 * 具体工厂
 */
public class ChinaKfcFactory implements IKfcFactory {

    @Override
    public Hamburg createHamBurg(int num) {
        return new ChinaHanBurm(num);
    }

    @Override
    public FrenchFries createFrenchFries(int num) {
        return new ChinaFrenchFries(num);
    }

    @Override
    public ChickenWings createChickenWings(int num) {
        return new ChinaChickenWings(num);
    }

    @Override
    public Beverage createBeverage(int num) {
        return new ChinaBeverage(num);
    }
}
