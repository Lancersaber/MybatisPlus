package com.lancer.结构型模式.代理模式.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicClinent {

    public static void main(String args[]){
        //真实处理对象
        InvocationHandler handler=new TargetImpl();

        //创建代理类实例对象
        ITarget target= (ITarget) Proxy.newProxyInstance(ITarget.class.getClassLoader(),new Class[]{ITarget.class},handler);
        //操作方法
        target.operation();
    }
}
