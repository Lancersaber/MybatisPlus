package 第14章类型信息.proxy.myownproxy.NoJDK;

import 第14章类型信息.proxy.myownproxy.UseJdk.Person;
import 第14章类型信息.proxy.myownproxy.UseJdk.PersonImpl;

public class CustomTest {

    public static void main(String[] args) {
        MyPersonInvocationHandler personInvocationHandler = new MyPersonInvocationHandler(
                new PersonImpl());
        Person personProxy = (Person) MyProxy.newProxyInstance(
                new MyClassLoader(), PersonImpl.class.getInterfaces(),
                personInvocationHandler);
        personProxy.eat();
    }
}
