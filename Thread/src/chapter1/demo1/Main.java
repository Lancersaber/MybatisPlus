package chapter1.demo1;

public class Main {

    public static void main(String[] args){
        System.out.println("Testing Gate");
        Gate gate=new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Brazil").start();
        new UserThread(gate,"Chris","Canada").start();
        /**
         *      从程序的运行结果可见，此程序肯定是线程不安全的。
         * 原因：通常情况下，线程并不会考虑其他线程的操作，而是自己一直跑下去。
         *      对于name字段，两个相互竞争的线程中获胜的一方会先写入值。对于address字段同样如此，两个线程会再次竞争，获胜的一方先写入值。
         * 这就是所谓的数据竞争。此时，各字段的值都无法预测。
         */
    }
}
