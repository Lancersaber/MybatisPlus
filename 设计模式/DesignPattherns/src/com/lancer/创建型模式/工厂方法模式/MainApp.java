package com.lancer.创建型模式.工厂方法模式;

public class MainApp {

    public static void main(String args[]){

        //创建曹操实例对象(返回使用接口类型ISwordFactory)
        ISwordFactory swordFactory=new Caocao();
        //获得宝刀实例---七星宝刀
        AbstractSword sword = swordFactory.createSword();
        System.out.println("曹操使用"+sword.getName()+"刺杀董卓！");
    }
}
