package com.lancer.行为型模式.观察者模式.observer;

import com.lancer.行为型模式.观察者模式.subject.ISubject;

//政府用户观察者
public class GovernmentObserver implements IObserver {
    @Override
    public void update(ISubject subject) {
        System.out.println("政府部门收到高温预警："+subject.temperatureReport());
    }
}
