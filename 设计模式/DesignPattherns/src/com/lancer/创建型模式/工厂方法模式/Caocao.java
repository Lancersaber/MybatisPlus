package com.lancer.创建型模式.工厂方法模式;

public class Caocao implements ISwordFactory {

    /**
     * 实现ISwordFactory接口的createSword方法，生产七星宝刀
     * @return
     */
    @Override
    public AbstractSword createSword() {
        return new QiXingSword();
    }
}
