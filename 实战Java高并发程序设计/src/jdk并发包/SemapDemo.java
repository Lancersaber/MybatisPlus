package jdk并发包;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable {

    final Semaphore semp=new Semaphore(5);

    @Override
    public void run() {
        try {
            //申请信号量
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" : done!");
            //离开时必须执行release方法释放信号量
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService exec= Executors.newFixedThreadPool(20);
        final SemapDemo demo=new SemapDemo();
        for (int i=0;i<20;i++){
            exec.submit(demo);
        }
    }
}
