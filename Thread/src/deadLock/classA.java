package deadLock;

public class classA {

    public void test(String s1,String s2){
        synchronized (s1){
            synchronized (s2){
                System.out.println("hello");
            }
        }
    }
}
