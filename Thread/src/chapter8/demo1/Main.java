package chapter8.demo1;

public class Main {

    public static void main(String[] args){
        Channel channel=new Channel(5); //工人线程的个数
        channel.startWorkers();//在这里已经启动了所有的工人线程
        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();
    }
}
