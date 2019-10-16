package 第15章泛型.generator.generic_generator;

import 第15章泛型.generator.Generator;

/**
 *  这个类提供了一个基本实现，用以生成某个类的对象。这个类必须具备两个特点：
 *  1、它必须声明为public.(因为BasicGenerator与要处理的类在不同的包中，所以该类必须声明为public，并且不只具有包访问权限)
 *  2、它必须具备默认的构造器(无参构造器)
 */

public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type=type;
    }

    @Override
    public T next() {
        try {
            //Assumes type is a public class
//            T newInstance()
//            创建由此 类对象表示的类的新实例。
            return type.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
}
