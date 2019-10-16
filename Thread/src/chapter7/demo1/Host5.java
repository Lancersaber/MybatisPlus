package chapter7.demo1;

import java.util.concurrent.Executor;

/**
 *  java.util.concurrent.Executor接口声明了如下所示的一个execute方法
 * void execute(Runnable r)
 *
 * Executor接口将某些“处理的执行”抽象化了，参数传入的Runnable对象表示“执行处理”的内容
 */
public class Host5 {
    private final Helper helper=new Helper();
    private final Executor executor;

    public Host5(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count,final char c){
        System.out.println("     handle("+count+","+c+") BEGIN");
        executor.execute(
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
