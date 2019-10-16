package anotherChapter8;

import java.util.concurrent.Callable;

public class myFuture implements Callable<String> {
    @Override
    public String call() throws Exception {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<10000;i++){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
