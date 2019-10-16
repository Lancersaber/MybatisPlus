package com.lancer.创建型模式.建造者模式.Interfaces;

import com.lancer.创建型模式.建造者模式.base.AbstractBasePackage;
import com.lancer.创建型模式.建造者模式.model.MobilePackage;

public class MobileBuilderImpl2 extends AbstractBasePackage implements  IMobileBuilder {
    /**
     * 套餐1
     */
    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(30.0f);
    }

    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(600);
    }

    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("大海");
    }

    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }
}
