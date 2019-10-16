package 第14章类型信息.proxy.SimpleProxyDemo;

public class SimpleProxyDemo {

    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
}
