package com.lancer.行为型模式.观察者模式.observer;

import com.lancer.行为型模式.观察者模式.subject.ISubject;

public class CompanyObserver implements IObserver {
    @Override
    public void update(ISubject subject) {
        System.out.println("企业单位收到高温预警："+subject.temperatureReport());
    }
}
