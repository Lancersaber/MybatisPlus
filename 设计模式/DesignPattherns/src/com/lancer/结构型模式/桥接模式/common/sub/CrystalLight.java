package com.lancer.结构型模式.桥接模式.common.sub;

import com.lancer.结构型模式.桥接模式.common.AbstractSwitch;

public class CrystalLight extends AbstractSwitch {
    @Override
    public void turnOn() {
        System.out.println("水晶灯打开了...");
    }

    @Override
    public void light() {
        System.out.println("水晶灯照明...");
    }

    @Override
    public void turnOff() {
        System.out.println("水晶灯关闭了...");
    }

    /**
     * 使用遥控开关控制开灯
     */
    public final void makeRemoteLight(int openColor){
        //打开开关，接通电流
        this.turnOn();
        //照明
        this.light();
        String color="";
        switch (openColor){
            case 1:
                color="暖色";
                break;
            case 2:
                color="蓝色";
                break;
            case 3:
                color="红色";
                break;
            default:
                color="白色";
                break;
        }
        System.out.println("...现在是"+color+"!");

        //关闭开关，断开电流
        this.turnOff();
    }
}
