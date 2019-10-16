package com.lancer.行为型模式.观察者模式.subject;

import com.lancer.行为型模式.观察者模式.observer.IObserver;

/**
 * 主题接口(被观察者)
 *
 */
public interface ISubject {

    //增加观察者
    public boolean add(IObserver observer);

    //删除观察者
    public boolean remove(IObserver observer);

    //通知所有观察者更新数据
    public void notifyAllObserver();

    //设置温度值
    public void setTemperature(float temperature);

    //获得温度预警
    public String temperatureReport();
}
