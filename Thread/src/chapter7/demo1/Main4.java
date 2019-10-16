package chapter7.demo1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *  java.util.concurrent.Executors类提供了许多实用的静态方法。例如
 * Executors.defaultThreadFactory()表达式可以获取当前默认设置的ThreadFactory对象。
 */
public class Main4 {

    public static void main(String[] args){
        System.out.println("main BEGIN");
        Host3 host=new Host3(
                Executors.defaultThreadFactory()
        );
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("main END");
    }
}
