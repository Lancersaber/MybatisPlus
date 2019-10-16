package anotherChapter2;

import java.util.concurrent.atomic.AtomicLong;

public class Test extends Thread {
    private static volatile int id=0;
    private static final AtomicLong count=new AtomicLong(0);

    public void run(){
        for (int i=0;i<10000;i++){
            id++;
            count.incrementAndGet();
        }
    }

    public long getId(){
//        return count.get();
        return id;
    }
}
