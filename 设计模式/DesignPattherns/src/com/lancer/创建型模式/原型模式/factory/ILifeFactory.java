package com.lancer.创建型模式.原型模式.factory;

import com.lancer.创建型模式.原型模式.pojo.DayLife;

public interface ILifeFactory {

    /**
     * 生产DayLife对象
     */

    public DayLife getNewInstance();
}
