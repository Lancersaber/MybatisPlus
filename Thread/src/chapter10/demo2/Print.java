package chapter10.demo2;

public class Print extends Thread {

    public void run(){
        for (int i=0;i<10000;i++){
            if (i==20){
                interrupt();
            }
            if (isInterrupted()){
                break;
            }
            System.out.println("i = "+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
