package chapter12.demo1;

//ActiveObjectFactory 是用于构成ActiveObject对象的类
public class ActiveObjectFactory {
    public static ActiveObject createActiveObject(){
        Servant servant=new Servant();//执行实际处理的类
        ActivationQueue queue=new ActivationQueue();///按顺序保存MethodRequest对象的类
        SchedulerThread scheduler=new SchedulerThread(queue);
        Proxy proxy=new Proxy(scheduler,servant);
        scheduler.start();
        return proxy;
    }
}
