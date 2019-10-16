package com.lancer.结构型模式.桥接模式.使用模式后的.lights;

public interface ILight {

    //接通电源
    public void electricConnected();

    //照明
    public void light();

    //断开电流
    public void eletricClosed();
}
