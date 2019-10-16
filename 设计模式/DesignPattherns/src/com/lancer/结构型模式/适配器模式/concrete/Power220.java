package com.lancer.结构型模式.适配器模式.concrete;

import com.lancer.结构型模式.适配器模式.power.AbsBasePower;
import com.lancer.结构型模式.适配器模式.power.IPower220;

public class Power220 extends AbsBasePower implements IPower220 {

    public Power220(){
        super(220);
    }

    @Override
    public void output220v() {
        System.out.println("---这是【"+this.getPower()+this.getUnit()+"】电源！");
    }
}
