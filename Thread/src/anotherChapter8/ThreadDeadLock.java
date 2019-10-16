package anotherChapter8;

import java.util.concurrent.*;

public class ThreadDeadLock {
    ExecutorService exec= Executors.newSingleThreadExecutor();

    public class RenderTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            Future<String> s1,s2;
            s1=exec.submit(new myFuture());
            s2=exec.submit(new myFuture());
            return s1.get()+s2.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec= Executors.newSingleThreadExecutor();
        Future<String> s1,s2;
        s1=exec.submit(new myFuture());
        s2=exec.submit(new myFuture());
        System.out.println(s1.get());
        System.out.println(s2.get());
        //为什么任务执行完成程序未结束？？？
    }
}
