package com.lancer.创建型模式.工厂方法模式;

/**
 * 宝刀工厂
 */
public interface ISwordFactory {

    /**
     * 生产各种宝刀(返回值是抽象宝刀类型)
     */
    public AbstractSword createSword();
}
