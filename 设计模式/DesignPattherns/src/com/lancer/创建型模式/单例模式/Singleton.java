package com.lancer.创建型模式.单例模式;

/**
 * 在Singleton类中需要做三点处理
 * 1）含有一个静态私有的共享对象实例对象，声明为static，类对象实例
 * 2）构造方法显示声明为私有方式，即private声明方式，外部不能创建这个对象实例
 * 3）含有一个获得单例对象的方法，即该类自行向整个系统提供这个实例
 */
//单例设计模式
public class Singleton {

    //类共享实例对象
    private static Singleton singleton=null;

    //私有构造方法
    private Singleton(){
        System.out.println("---this is Singleton!!");
    }

    //获得单例方法
    public synchronized static Singleton getInstance(){
        //判断共享对象是否为null，如果为null，则new一个新对象
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
