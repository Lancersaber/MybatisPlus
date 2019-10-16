package com.lancer.结构型模式.装饰者模式.common;

import com.lancer.结构型模式.装饰者模式.abs.IBread;
import com.lancer.结构型模式.装饰者模式.abs.NormalBread;

public class Client {

    public static void main(String args[]){
        //生产正常的馒头
        System.out.println("=========开始生产正常馒头.......");
        //创建普通的馒头实例
        IBread normalBread =new NormalBread();
        //加工馒头
        normalBread.process();
        System.out.println("========正常馒头生产结束....");

        //生产染色的馒头
        System.out.println("\n=========开始生产染色馒头.......");
        //创建普通的馒头实例
        IBread normalBread2 =new CornBread();
        //加工馒头
        normalBread2.process();
        System.out.println("========染色馒头生产结束....");

    }
}
