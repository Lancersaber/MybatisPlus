package chapter7.demo1;

import java.util.concurrent.Executor;

public class Main5 {

    public static void main(String[] args){
        System.out.println("main BEGIN");
        Host5 host=new Host5(
                new Executor() {
                    @Override
                    public void execute(Runnable command) {
                        new Thread(command).start();
                    }
                }
        );
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("main END");
    }
}
