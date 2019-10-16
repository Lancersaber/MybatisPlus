package chapter6.demo1;

import java.util.Random;

//WriterThread类表示的是对Data 实例执行写入操作的线程。
// 构造函数的参数filter 是一个字符串，程序会逐个取出该字符串中的字符，并write到Data的实例中
public class WriterThread extends Thread{
    private static final Random random=new Random();
    private final Data data;
    private final String filler;
    private int index=0;
    public WriterThread(Data data,String filler){
        this.data=data;
        this.filler=filler;
    }

    public void run(){
        try {
            while (true){
                char c=nextchar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextchar(){
        char c=filler.charAt(index);
        index++;
        if (index>= filler.length()){
            index=0;
        }
        return c;
    }
}
