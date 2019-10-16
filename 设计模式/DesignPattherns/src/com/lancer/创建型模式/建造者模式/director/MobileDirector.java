package com.lancer.创建型模式.建造者模式.director;

import com.lancer.创建型模式.建造者模式.Interfaces.IMobileBuilder;
import com.lancer.创建型模式.建造者模式.model.MobilePackage;

/**
 * 手机套餐指导者
 */
public class MobileDirector {

    public MobilePackage createMobilePackage(IMobileBuilder mobileBuilder){
        if(mobileBuilder!=null){
            //构建花费
            mobileBuilder.buildMoney();

            //构建短信
            mobileBuilder.buildShortInfo();
            //构建彩铃
            mobileBuilder.buildMusic();
            //返回手机套餐
            return mobileBuilder.getMobilePackage();
        }
        return null;
    }

}
