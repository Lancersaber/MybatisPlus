package anotherChapter3;

public class Novisibility1 {
    private static boolean ready;
    private static int number;

    public static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                System.out.println("我拿到锁了");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number=42;
        Thread.sleep(1000);
        ready=true;
    }
}
