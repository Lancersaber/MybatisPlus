package com.lancer.结构型模式.装饰者模式.decorator;

import com.lancer.结构型模式.装饰者模式.abs.IBread;
//抽象装饰者
public abstract class AbstractBread implements IBread {

    //存储传入的IBread对象
    private final IBread bread;

    public AbstractBread(IBread bread){
        this.bread=bread;
    }

    public void prepair(){
        this.bread.prepair();;
    }

    public void kneadFlour(){
        this.bread.kneadFlour();
    }

    public void steamed(){
        this.bread.steamed();
    }

    public void process(){
        prepair();
        kneadFlour();
        steamed();
    }
}
