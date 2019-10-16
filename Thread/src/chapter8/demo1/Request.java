package chapter8.demo1;

import java.util.Random;

//表示工作请求的类
public class Request {
    private final String name; //委托者
    private final int number;//请求的编号
    private static final Random random=new Random();

    public Request(String name,int number){
        this.name=name;
        this.number=number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+" executes "+this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "[ Request from "+name+" No."+number+" ]";
    }
}
