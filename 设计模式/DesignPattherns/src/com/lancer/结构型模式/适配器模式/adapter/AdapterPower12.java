package com.lancer.结构型模式.适配器模式.adapter;

import com.lancer.结构型模式.适配器模式.power.AbsBasePower;
import com.lancer.结构型模式.适配器模式.power.IPower12;

/**
 * 电源适配器(实现目标接口，即12v)
 */
public class AdapterPower12 implements IPower12 {

    //待转换的对象
    private final AbsBasePower absBasePower;

    //适配器构造器方法，获得转换对象传入
    public AdapterPower12(AbsBasePower absBasePower){
        this.absBasePower=absBasePower;
    }

    @Override
    //实现目标对象方法
    public void output12v() {
        //获得外部电源值
        float powerFloat=this.absBasePower.getPower();
        //进行电源转换
        if(powerFloat==380){
            //380v电源转换
            powerFloat/=31.67f;
        }else if(powerFloat==220){
            //220v电源转换
            powerFloat=powerFloat/18.33f;
        }else if(powerFloat==110){
            //110V电源转换
            powerFloat=powerFloat/9.17f;
        }else {
            System.out.println("-----不能适配电脑！-------");
            return;
        }

        //处理转换结果
        powerFloat=(int) (powerFloat*10)/10;
        System.out.println("----这是["+powerFloat+this.absBasePower.getUnit()+"]电源！");
    }
}
