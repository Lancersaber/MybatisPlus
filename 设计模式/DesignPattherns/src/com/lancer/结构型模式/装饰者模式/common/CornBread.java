package com.lancer.结构型模式.装饰者模式.common;

import com.lancer.结构型模式.装饰者模式.abs.NormalBread;

//染色的玉米馒头
public class CornBread extends NormalBread {

    //黑心商贩开始染色
    public void paint(){
        System.out.println("添加柠檬黄的着色剂....");
    }

    //重载父类的和面方法

    @Override
    public void kneadFlour() {
        //在面粉中加入染色剂后才开始和面
        this.paint();
        //和面
        super.kneadFlour();
    }
}
