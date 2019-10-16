package com.lancer.结构型模式.适配器模式.concrete;

import com.lancer.结构型模式.适配器模式.power.AbsBasePower;
import com.lancer.结构型模式.适配器模式.power.IPower12;

public class Power12 extends AbsBasePower implements IPower12 {

    public Power12(){
        super(12);
    }

    @Override
    public void output12v() {
        System.out.println("---这是【"+this.getPower()+this.getUnit()+"】电源！");
    }
}
