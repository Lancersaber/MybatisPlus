package chapter3.demo1;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue=new LinkedList<>();
    public synchronized Request getRequest(){


        /**
         * 这里将while换成if会有什么后果
         *      在该示例中是不会发生问题的，但是一般情况下还是会发生问题
         *      这里假设多个线程都在wait时，RequestQueue的实例被执行了notifyAll().这样一来，多个线程都会
         * 开始运行。这时，如果queue中只有一个元素，第一个开始运行的线程调用queue.remove()后，queue会变为空；
         * 若queue为空，queue.peek()的值则为null。但如果第二个及之后开始运行的线程之前已经确认守护条件成立，那么
         * 即使这时queue.peek() == null,queue.remove() 也还是会被调用。因此，使用这个类时，程序可能会欠缺安全性。
         *
         */
        while (queue.peek()==null){ //当事件队列为空时 queue.peek()!=null 是守护条件
            try {
                System.out.println(Thread.currentThread().getName()+" : wait() begins,queue = "+queue);
                wait();
                System.out.println(Thread.currentThread().getName()+" :wait() ends,queue = "+queue);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //上面的while语句保证在remove方法调用时。守护条件一定是成立的
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        System.out.println(Thread.currentThread().getName()+": notifyAll() begins, queue = "+queue);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" :notifyAll() ends,queue = "+queue);
    }
}
