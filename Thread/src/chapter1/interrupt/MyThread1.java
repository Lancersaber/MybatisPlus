package chapter1.interrupt;

public class MyThread1 extends Thread{

    public void run(){
        super.run();
        for (int i=0;i<500000;i++){
            if (this.isInterrupted()){
                System.out.println("已经是停止状态了！我要退出了！");
                break;
            }
            System.out.println("i=" +(i+1));
        }
    }
}