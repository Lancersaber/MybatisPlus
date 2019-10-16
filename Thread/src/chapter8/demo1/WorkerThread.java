package chapter8.demo1;

//WorkerThread 类是表示工人线程的类
public class WorkerThread extends Thread{
    private final Channel channel;

    public WorkerThread(String name,Channel channel){
        super(name);
        this.channel=channel;
    }

    public void run(){
        while (true){
            Request request=channel.takeRequest();
            request.execute();
        }
    }
}
