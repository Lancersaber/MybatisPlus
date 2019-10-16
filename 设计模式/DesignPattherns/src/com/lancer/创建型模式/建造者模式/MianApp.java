package com.lancer.创建型模式.建造者模式;

import com.lancer.创建型模式.建造者模式.Interfaces.MobileBuilderImpl;
import com.lancer.创建型模式.建造者模式.Interfaces.MobileBuilderImpl2;
import com.lancer.创建型模式.建造者模式.director.MobileDirector;
import com.lancer.创建型模式.建造者模式.model.MobilePackage;

public class MianApp {

    public static void main(String args[]){
        //创建指导者
        MobileDirector director=new MobileDirector();

        //套餐一
        MobileBuilderImpl mobileBuilder1=new MobileBuilderImpl();
        //套餐二
        MobileBuilderImpl2 mobileBuilder2=new MobileBuilderImpl2();

        printMessage(director.createMobilePackage(mobileBuilder1));

        printMessage(director.createMobilePackage(mobileBuilder2));
    }

    public static void printMessage(MobilePackage mobilePackage){
        System.out.println("--花费："+mobilePackage.getMoney()+"\t短信："+mobilePackage.getShortInfo()+"条\t彩铃："+mobilePackage.getMusic());
    }
}
