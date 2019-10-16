package anotherChapter2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Test test2 = new Test();
        test.start();
        test2.start();
        Thread.sleep(1000);
        System.out.println(test.getId());
    }
}
