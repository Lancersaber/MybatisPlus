package com.lancer.行为型模式.观察者模式;

import com.lancer.行为型模式.观察者模式.observer.CompanyObserver;
import com.lancer.行为型模式.观察者模式.observer.GovernmentObserver;
import com.lancer.行为型模式.观察者模式.observer.PersonObserver;
import com.lancer.行为型模式.观察者模式.subject.ISubject;
import com.lancer.行为型模式.观察者模式.subject.Subject;

import java.util.Random;

public class Client {

    public static void main(String args[]){
        //创建主题对象
        ISubject subject=new Subject();

        //增加企业单位观察者
        subject.add(new CompanyObserver());

        //增加政府用户观察者
        subject.add(new GovernmentObserver());

        //增加个人用户观察者
        subject.add(new PersonObserver());

        Random random=new Random();

        int i=0;

        while (++i<10){
            //设置随机温度
            subject.setTemperature(random.nextInt(45));
        }
    }

}
