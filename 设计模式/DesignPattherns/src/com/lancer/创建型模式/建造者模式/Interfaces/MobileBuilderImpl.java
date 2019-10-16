package com.lancer.创建型模式.建造者模式.Interfaces;

import com.lancer.创建型模式.建造者模式.base.AbstractBasePackage;
import com.lancer.创建型模式.建造者模式.model.MobilePackage;

public class MobileBuilderImpl extends AbstractBasePackage implements  IMobileBuilder {
    /**
     * 套餐1
     */
    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(20.0f);
    }

    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(400);
    }

    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("天使");
    }

    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }
}
