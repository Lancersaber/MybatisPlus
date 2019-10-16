package com.lancer.创建型模式.建造者模式.Interfaces;

import com.lancer.创建型模式.建造者模式.model.MobilePackage;

/**
 * 手机套餐
 */
public interface IMobileBuilder {

    //建造手机套餐的花费
    public void buildMoney();

    //建造手机套餐的短信
    public void buildShortInfo();

    //建造手机套餐的彩铃
    public void buildMusic();

    //返回建造的手机套餐对象
    public MobilePackage getMobilePackage();
}
