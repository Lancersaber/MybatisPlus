package com.lancer.行为型模式.观察者模式.observer;

import com.lancer.行为型模式.观察者模式.subject.ISubject;

//个人用户观察者
public class PersonObserver implements IObserver {
    @Override
    public void update(ISubject subject) {
        System.out.println("个人收到高温预警："+subject.temperatureReport());
    }
}
