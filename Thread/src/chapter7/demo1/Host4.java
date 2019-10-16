package chapter7.demo1;

import java.util.concurrent.ThreadFactory;

/**
 *  java.util.concurrent.ThreadFactory接口声明了如下所示的一个newThread方法
 *
 *  Thread newThread(Runnable r);
 *  ThreadFactory是将线程创建抽象化了的接口，参数中的Runnable对象表示线程执行的操作内容。
 *
 */
public class Host4 {
    private final Helper helper=new Helper();
    private final ThreadFactory threadFactory;

    public Host4(ThreadFactory threadFactory){
        this.threadFactory=threadFactory;
    }

    public void request(final int count,final char c){
        System.out.println("     handle("+count+","+c+") BEGIN");
        threadFactory.newThread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count,c);
                    }
                }
        );
        System.out.println("     handle("+count+","+c+") END");
    }
}
