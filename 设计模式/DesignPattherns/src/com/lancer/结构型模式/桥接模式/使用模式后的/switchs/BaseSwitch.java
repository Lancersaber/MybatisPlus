package com.lancer.结构型模式.桥接模式.使用模式后的.switchs;

import com.lancer.结构型模式.桥接模式.使用模式后的.lights.ILight;

public class BaseSwitch {

    //使用组合，设置ILight为内部私有属性，此为桥梁
    protected ILight light;

    //构造方法将外部的light类型注入进来
    public BaseSwitch(ILight light){
        this.light=light;
    }

    //开灯方法
    public final  void makeLight(){
        //打开开关，接通电流
        this.light.electricConnected();
        //照明
        this.light.light();
        //关闭开关，断开电流
        this.light.eletricClosed();
    }
}
