package com.lancer.结构型模式.桥接模式.使用模式后的.switchs.sub;

import com.lancer.结构型模式.桥接模式.使用模式后的.lights.ILight;
import com.lancer.结构型模式.桥接模式.使用模式后的.switchs.BaseSwitch;

/**
 * 遥控开关，继承BaseSwitch 扩展功能
 */
public class RemoteControlSwitch extends BaseSwitch {


    //构造方法
    public RemoteControlSwitch(ILight light) {
        super(light);
    }

    //使用遥控开关控制开关
    public final void makeRemoteLight(int openColor){
        //打开开关，接通电流
        this.light.electricConnected();
        //照明
        this.light.light();
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
                color="默认色";
                break;
        }
        System.out.println("...现在是"+color+"!");

        //关闭开关，断开电流
        this.light.eletricClosed();
    }
}
