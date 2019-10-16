package com.lancer.结构型模式.桥接模式.common;

import com.lancer.结构型模式.桥接模式.common.sub.CrystalLight;
import com.lancer.结构型模式.桥接模式.common.sub.IncandescentLight;

/**
 * 客户端应用程序
 */
public class Client {

    public static void main(String args[]){
        //白炽灯实例
        AbstractSwitch light=new IncandescentLight();

        //水晶灯实例
        CrystalLight light1=new CrystalLight();

        System.out.println("----- 一般开关 --");
        //一般开关
        light.makeLight();

        System.out.println("\n--遥控开关 --");
        //遥控开关
        light1.makeRemoteLight(1);
        /**
         * 对代码的思考：
         *      我现在想要用遥控开关白炽灯，该怎么办吗？
         *      有了，在创建一个子类不就解决问题了吗？哦，这样开销太大了。白炽灯是有的，遥控开关也是有的，为什么还要新建一个类呢？
         * 问题出在，我们一开始的设计思路就是错误的。不应该使用继承，因为继承使用开关和电灯关联得太强了，也就是一个开关控制一种灯，
         * 要想更换其他种类的电灯就必须配备相应的开关才行。更换电灯同时还要更换开关。这是不应该出现的。
         */
    }
}
