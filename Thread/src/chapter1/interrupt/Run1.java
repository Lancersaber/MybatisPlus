package chapter1.interrupt;

public class Run1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread1 thread=new MyThread1();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
