package chapter1.interrupt;

public class MyThread extends Thread {

    public void run(){
        super.run();
        if (this.isInterrupted()){
            System.out.println("=============================");
        }
        for (int i=0;i<500000;i++){
            if (i==250000){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i= "+(i+1));
        }
    }
}
