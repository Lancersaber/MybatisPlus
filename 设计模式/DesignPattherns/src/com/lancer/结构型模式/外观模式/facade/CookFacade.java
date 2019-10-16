package com.lancer.结构型模式.外观模式.facade;

import com.lancer.结构型模式.外观模式.common.ISpareribs;
import com.lancer.结构型模式.外观模式.common.Spareribs;

//外观模式制作糖醋排骨
public class CookFacade implements ICookFacade {

    //糖醋排骨排骨接口
    private final ISpareribs spareribs=new Spareribs();

    @Override
    public void cookSpareribs() {
        this.spareribs.prepair();
        this.spareribs.preserve();
        this.spareribs.fry();
        this.spareribs.juice();
    }
}
