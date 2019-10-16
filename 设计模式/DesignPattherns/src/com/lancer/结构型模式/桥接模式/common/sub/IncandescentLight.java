package com.lancer.结构型模式.桥接模式.common.sub;

import com.lancer.结构型模式.桥接模式.common.AbstractSwitch;

/**
 * 白炽灯
 */
public class IncandescentLight extends AbstractSwitch {
    @Override
    public void turnOn() {
        System.out.println("白炽灯打开了...");
    }

    @Override
    public void light() {
        System.out.println("白炽灯照明！");
    }

    @Override
    public void turnOff() {
        System.out.println("白炽灯关闭了...");
    }
}
