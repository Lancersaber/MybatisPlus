package com.lancer.创建型模式.原型模式;

import com.lancer.创建型模式.原型模式.factory.ILifeFactory;
import com.lancer.创建型模式.原型模式.factory.impl.LifefactoryImpl;
import com.lancer.创建型模式.原型模式.pojo.DayLife;

public class Client {


    public static void main(String args[]){
        //创建工厂
        ILifeFactory lifeFactory=new LifefactoryImpl();
        //打印输出DayLife默认内容
        DayLife dayLife2= lifeFactory.getNewInstance();
        dayLife2.print();
        System.out.println(dayLife2);

        //再次获得DayLife，修改getUp内容后，输出内容
        System.out.println("--------------------------");
        DayLife dayLife=lifeFactory.getNewInstance();
        dayLife.setGetUp("早上赖床了！7：15才起床");
        dayLife.print();
        System.out.println(dayLife);

        //再次获得DayLife，修改getUp内容后 输出内容
        System.out.println("------------------------------");
        DayLife dayLife1=lifeFactory.getNewInstance();
        dayLife1.setGetUp("早上赖床了！7：30才起床");
        dayLife1.print();
        System.out.println(dayLife1);

        System.out.println("-------------------------");
        dayLife2.print();
    }


}
