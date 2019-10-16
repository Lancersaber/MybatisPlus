package com.lancer.结构型模式.桥接模式.使用模式后的;

import com.lancer.结构型模式.桥接模式.使用模式后的.lights.ILight;
import com.lancer.结构型模式.桥接模式.使用模式后的.lights.Impl.CrystalLight;
import com.lancer.结构型模式.桥接模式.使用模式后的.lights.Impl.IncandescentLight;
import com.lancer.结构型模式.桥接模式.使用模式后的.switchs.BaseSwitch;
import com.lancer.结构型模式.桥接模式.使用模式后的.switchs.sub.RemoteControlSwitch;

public class ClientForBridge {

    public static void main(String args[]){
        //白炽灯实例
        ILight incandescentLight=new IncandescentLight();

        //水晶灯实例
        ILight crystalLight=new CrystalLight();

        //一般开关
        System.out.println("-- 一般开关 ---");
        BaseSwitch switch1=new BaseSwitch(incandescentLight);

        switch1.makeLight();
        System.out.println("-- 遥控开关 --");
        //遥控开关
        RemoteControlSwitch remoteControlSwitch=new RemoteControlSwitch(crystalLight);
        remoteControlSwitch.makeRemoteLight(1);

    }
}
