package com.lancer.结构型模式.装饰者模式.decorator;

import com.lancer.结构型模式.装饰者模式.abs.IBread;

/**
 * 甜蜜素馒头
 */
public class SweetDecorator extends AbstractBread{

    //构造方法
    public SweetDecorator(IBread bread){
        super(bread);
    }

    //黑心商贩开始染色
    public void paint(){
        System.out.println("添加甜蜜素的着色剂...");
    }

    //重载父类的和面方法
    public void kneadFlour(){
        //在面粉中加入染色剂之后才开始和面
        this.paint();
        super.kneadFlour();
    }
}
