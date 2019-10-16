package chapter12.demo1;

//调用execute方法处理MethodRequest对象的类
public class SchedulerThread extends Thread {
    private final ActivationQueue queue;
    public SchedulerThread(ActivationQueue queue){
        this.queue=queue;
    }

    public void invoke(MethodRequest request){
        queue.putRequest(request);
    }

    public void run(){
        while (true){
            MethodRequest request=queue.takeRequest();
            request.execute();
        }
    }
}
