package 第14章类型信息.proxy.myownproxy.UseJdk;

import java.lang.reflect.Proxy;

public class jdkTest {

    public static void main(String[] args) throws Exception {
        PersonInvocationHandler personInvocationHandler = new PersonInvocationHandler(
                new PersonImpl());
        Person personProxy = (Person) Proxy.newProxyInstance(
                PersonImpl.class.getClassLoader(),
                PersonImpl.class.getInterfaces(), personInvocationHandler);
        personProxy.eat();
    }
}