package com.lancer.结构型模式.代理模式.real.Impl;

import com.lancer.结构型模式.代理模式.real.IRedWine;

public class RealRedWineFactory implements IRedWine {

    @Override
    public void product() {
        System.out.println("红酒工厂生产红酒...");
    }

    @Override
    public void sell() {
        System.out.println("红酒工厂销售红酒...");
    }
}
