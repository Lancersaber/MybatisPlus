package com.lancer.行为型模式.观察者模式.subject;

import com.lancer.行为型模式.观察者模式.observer.IObserver;

import java.util.Iterator;
import java.util.Vector;

//主题实现者(被观察者)
public class Subject implements ISubject{

    //温度

    /**
     * 一 高温黄色预警信号
     * 标准：连续三天日最高气温将在35度以上
     *
     * 二 高温橙色预警信号
     * 标准：24小时内最高气温将升至37度以上
     *
     * 三 高温红色预警信号
     * 标准：24小时内最高气温将升至40度以上
     * @param observer
     * @return
     */
    private float temperature;
    //预警级别
    private String warningLevel;

    //保存观察者列表
    private Vector<IObserver> vector;

    //构造方法，初始化观察者列表
    public Subject(){
        vector=new Vector<IObserver>();
    }
    //增加观察者
    @Override
    public boolean add(IObserver observer) {
        if(observer!=null&&!vector.contains(observer)){
            return vector.add(observer);
        }
        return false;
    }

    //移除观察者
    @Override
    public boolean remove(IObserver observer) {
        return vector.remove(observer);
    }

    @Override
    //通知所有观察者更新
    public void notifyAllObserver() {
        System.out.println("========气象部门发布高温"+this.warningLevel+"警报！===========");
        Iterator<IObserver> iterator=vector.iterator();
        while (iterator.hasNext()){
            (iterator.next()).update(this);
        }
    }

    //私有方法，根据温度值设置预警级别，然后通知所有观察者
    private void invoke(){
        if(this.temperature>=35){
            if(this.temperature>=35&&this.temperature<37)
            {
                this.warningLevel="黄色";
            }
            else if(this.temperature>=37&&this.temperature<40){
                this.warningLevel="橙色";
            }else if(this.temperature>=40){
                this.warningLevel="红色";
            }
            //通知所有观察者温度状况
            this.notifyAllObserver();
        }
    }


    @Override
    public void setTemperature(float temperature) {
        this.temperature=temperature;

        invoke();
    }

    @Override
    public String temperatureReport() {
        return "温度："+this.temperature;
    }
}
