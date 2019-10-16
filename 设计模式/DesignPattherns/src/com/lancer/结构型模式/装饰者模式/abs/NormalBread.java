package com.lancer.结构型模式.装饰者模式.abs;

public class NormalBread implements IBread {

    @Override
    public void prepair() {
        System.out.println("准备面粉、水以及发酵粉...");
    }

    @Override
    public void kneadFlour() {
        System.out.println("和面...");
    }

    @Override
    public void steamed() {
        System.out.println("蒸馒头...香喷喷的馒头出炉了！");
    }

    @Override
    public void process() {
        //准备材料
        prepair();
        //和面
        kneadFlour();
        //蒸馒头
        steamed();
    }
}
