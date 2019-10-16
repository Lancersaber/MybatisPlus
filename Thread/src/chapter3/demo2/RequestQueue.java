package chapter3.demo2;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 分析：这里的take方法put方法都是BlockingQueue接口中声明的方法。
 * take用于"取出队首元素"，put方法则用于“向队尾元素添加元素”。
 * 当队列为空时，若调用take方法便会进行wait。
 *      由于take方法和put方法已经考虑了互斥处理，所以getRequest方法和putRequest方法也就无需声明为synchronized方法。
 * LinkedBlockingQueue类中使用了GuardedSuspension模式，能够保证线程安全。
 */
public class RequestQueue {
    private final BlockingQueue<Request> queue=new LinkedBlockingDeque<>();
    public Request getRequest(){
        Request req=null;
        try {
            req=queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return req;
    }

    public void putRequest(Request request){
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
