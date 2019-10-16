package chapter1;

public class isAlive extends Thread {
    public void run(){
        System.out.println("run= "+this.isAlive());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        isAlive mythread=new isAlive();
        System.out.println("begin == "+mythread.isAlive());
        mythread.start();
//        Thread.sleep(1000);//这个Thread 代表什么线程 应该是默认的 currentThread()
        System.out.println("end == "+mythread.isAlive());
    }
}
