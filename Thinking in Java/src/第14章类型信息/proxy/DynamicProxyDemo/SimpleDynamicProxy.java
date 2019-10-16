package 第14章类型信息.proxy.DynamicProxyDemo;

import 第14章类型信息.proxy.SimpleProxyDemo.Interface;
import 第14章类型信息.proxy.SimpleProxyDemo.RealObject;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {

    public static void main(String[] args){
        RealObject real=new RealObject();
        consumer(real);
        //Insert a proxy and call again
        Interface proxy=(Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(real));
        consumer(proxy);
    }

    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

}
