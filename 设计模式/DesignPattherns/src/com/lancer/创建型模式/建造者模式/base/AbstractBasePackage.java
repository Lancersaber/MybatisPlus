package com.lancer.创建型模式.建造者模式.base;

import com.lancer.创建型模式.建造者模式.model.MobilePackage;

public abstract class AbstractBasePackage {

    //手机套餐实例变量
    //这里需要注意，定义mobilePackage的时候需要使用protected保护模式，为了在不同包下的子类使用
    protected MobilePackage mobilePackage;

    public AbstractBasePackage(){
        this.mobilePackage=new MobilePackage();
    }
}
