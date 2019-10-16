package com.lancer.结构型模式.桥接模式.使用模式后的.lights.Impl;

import com.lancer.结构型模式.桥接模式.使用模式后的.lights.ILight;

public class CrystalLight implements ILight {

    @Override
    public void electricConnected() {
        System.out.println("水晶灯被打开了...");
    }

    @Override
    public void light() {
        System.out.println("水晶灯照明....");
    }

    @Override
    public void eletricClosed() {
        System.out.println("水晶灯关闭....");
    }
}
