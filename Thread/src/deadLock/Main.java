package deadLock;

public class Main {

    public static void main(String[] args){
        String s1="s1";
        String s2="s2";
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (s1) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (s2) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (s2) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (s1) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
