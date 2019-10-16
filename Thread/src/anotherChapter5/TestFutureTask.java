package anotherChapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFutureTask {

    private FutureTask<String> future=new FutureTask<>(
            new Callable<String>() {
                @Override
                public String call() throws Exception {
                    StringBuilder s=new StringBuilder();
                    for (int i=0;i<10000;i++){
                        s.append(i);
                    }

                    return s.toString();
                }
            }
    );

    private Thread thread=new Thread(future);

    public void start(){
        thread.start();
    }

    public String get() throws ExecutionException, InterruptedException {
        return future.get();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestFutureTask test=new TestFutureTask();
        test.start();
        long l = System.currentTimeMillis();
        String s = test.get();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println("result: "+s);
    }
}
