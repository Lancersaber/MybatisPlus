package com.lancer.结构型模式.适配器模式;

import com.lancer.结构型模式.适配器模式.adapter.AdapterPower12;
import com.lancer.结构型模式.适配器模式.concrete.Power12;
import com.lancer.结构型模式.适配器模式.concrete.Power220;
import com.lancer.结构型模式.适配器模式.power.IPower12;

public class Client {

    public static void main(String args[]){
        //
        Power220 power220=new Power220();
        power220.output220v();

        //
        Power12 power12=new Power12();
        power12.output12v();

        //最后使用电源适配器将220V电源转换为12V电源
        System.out.println("电源适配器转换中");
        IPower12 adapter=new AdapterPower12(power220);
        adapter.output12v();
        System.out.println("---电源适配器转换结束");
    }
}
