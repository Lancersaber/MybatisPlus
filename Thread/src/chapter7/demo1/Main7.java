package chapter7.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *      java.util.concurrent.ExecutorService接口。
 * ExecutorService接口对可以反复execute的服务进行了抽象化。线程一直在后台运行着，每当调用execute方法时，线程就会
 * 执行Runnable对象。
 *      通常情况下，在ExecutorService接口后面，线程是一直运行着的，所以ExecutorService接口提供了shutdown方法结束服务。
 *      由于ExecutorService接口是Executor的子接口，所以接收Executor对象的Host类也可以接收ExecutorService对象。
 *
 */
public class Main7 {

    public static void main(String[] args){
        System.out.println("main BEGIN");

        //Executors.newScheduledThreadPool();方法会创建“可复用线程型ScheduledExecutorService”对象
        //参数中的5表示无工作时也会一直持有的线程个数
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(5);

        Host7 host=new Host7(
                executorService
        );
        try {
            host.request(10,'A');
            host.request(20,'B');
            host.request(30,'C');
        }finally {
            //这里使用到了try...finally结构来执行shutdown。在对ExecutorService执行shutdown之后，新的请求不再被执行
            executorService.shutdown();
            System.out.println("main END");
        }
    }
}
