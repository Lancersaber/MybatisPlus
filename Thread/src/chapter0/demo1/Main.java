package chapter0.demo1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

//演示了如何使用ThreadFactory类来创建线程
public class Main {

    public static void main(String[] args){
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        Thread thread = threadFactory.newThread(new Printer("Nice"));
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadFactory.newThread(new Printer("Good")).start();
        for (int i=0;i<10000;i++){
            System.out.println("Good");
        }
    }
}
