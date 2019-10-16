package com.lancer.创建型模式.抽象工厂模式.concreate;

import com.lancer.创建型模式.抽象工厂模式.abstractClass.Hamburg;

public class ChinaHanBurm extends Hamburg {

    public ChinaHanBurm(int num){
        this.kind="麻辣";
        this.price=14.0f;
        this.num=num;
    }
}
