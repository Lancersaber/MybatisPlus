package com.lancer.行为型模式.观察者模式.observer;

import com.lancer.行为型模式.观察者模式.subject.ISubject;

public interface IObserver {

    //更新方法
    public void update(ISubject subject);
}
