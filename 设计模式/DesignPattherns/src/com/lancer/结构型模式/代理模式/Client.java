package com.lancer.结构型模式.代理模式;

import com.lancer.结构型模式.代理模式.proxy.RedWineProxy;
import com.lancer.结构型模式.代理模式.real.IRedWine;
import com.lancer.结构型模式.代理模式.real.Impl.RealRedWineFactory;


public class Client {

    public static void main(String args[]){

        //直接去红酒工厂买红酒
        //创建红酒工厂
        IRedWine redWine=new RealRedWineFactory();

        //工厂生产红酒
        redWine.product();

        //工厂销售红酒
        redWine.sell();

        System.out.println("\n======去红酒代理商处购买红酒===========");
        //获得代理对象实例
        IRedWine redWineProxy=new RedWineProxy(redWine);
        //代理商生产红酒(其实真正生产的是工厂)
        redWineProxy.product();
        //代理商销售红酒
        redWineProxy.sell();
    }
}
