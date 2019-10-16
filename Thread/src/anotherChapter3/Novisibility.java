package anotherChapter3;

public class Novisibility {
    private String[] states = new String[]{"AK", "AL"};
    //states变量作用域是private而我们在getStates方法中却把它发布了，
    //这样就称为数组states逸出了它所在的作用域。
    public String[] getStates(){
        return states;
    }
    private int test=1;
    public int getTest(){
        return test;
    }
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new ReaderThread().start();
//        ready=true;
//        Thread.sleep(1000);
//        number=42;
        Novisibility no=new Novisibility();
        String[] states1 = no.getStates();
        states1[0]="AA";
        String[] states = no.getStates();
        int test = no.getTest();
        System.out.println("test = "+test);
        test=2;
        System.out.println("test = "+no.getTest());
        for (String s:states){
            System.out.println(s);
        }
    }
}
