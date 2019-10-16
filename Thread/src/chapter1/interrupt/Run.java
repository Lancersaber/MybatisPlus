package chapter1.interrupt;

public class Run {

    //调用interrupt()方法仅仅是在当前线程中打了一个停止标记，并不是真正的停止线程
    public static void main(String[] args){
        try {
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
            System.out.println("是否停止1？ = "+thread.isInterrupted() );
            System.out.println("是否停止2？ = "+thread.isInterrupted() );
            System.out.println("end!");
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

    }
}
