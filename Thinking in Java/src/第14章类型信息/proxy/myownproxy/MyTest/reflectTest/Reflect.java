package 第14章类型信息.proxy.myownproxy.MyTest.reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class Reflect {

    public static void print(Object object){
        Class<?> myclass=object.getClass();
        System.out.println(myclass.getSimpleName());
        Package aPackage=myclass.getPackage();
        System.out.println(aPackage.getName());

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> myclass=Person.class;
        Person person=new Person(12);
        Reflect.print(person);
        /**
            getDeclaredMethods(); 返回所有方法，但是不包括继承的方法
            getmethods() 返回继承的方法和自己定义的public方法
         */
       /* Method[] methods = myclass.getDeclaredMethods();
        Constructor<?>[] constructors = myclass.getConstructors();
        Constructor<?> constructor1 = myclass.getConstructor(String.class, int.class);
        Object zhangsan = constructor1.newInstance("zhangsan", 14);
        String name = myclass.getName();
        System.out.println("测试类的名字是 "+name);
        System.out.println("*************************");
        System.out.println("测试类的构造函数为");
        if (constructors!=null){
            for (Constructor constructor:constructors){
                System.out.println(constructor.toString());
            }
        }
        System.out.println("===============");
        for (Method method: methods){
            Class returnType=method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class classes:parameterTypes){
                System.out.println(classes.getName());
            }
            System.out.println(returnType.getName()+"  "+ method.getName());
            if (method.getName().equals("sayHello")){
                System.out.println("调用sayHello方法");
                method.invoke(zhangsan);
            }
        }

        Method method=myclass.getDeclaredMethod("run");
        method.setAccessible(true);
        method.invoke(zhangsan);*/


    }
}
