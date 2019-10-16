package chapter9.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//FutureData类是表示“提货单”的类
public class FutureData extends FutureTask<RealData> implements Data {

    public FutureData(Callable<RealData> callable){
        super(callable);
    }

    private RealData realData=null;
    private boolean ready=false; //表示是否已经为realData赋值

    public synchronized void setRealData(RealData realData){
        if (ready){
            return; //balk
        }
        this.realData=realData;
        this.ready=true;
        notifyAll();
    }

    @Override
    public String getContent() {
        String string=null;
        try {
            /**
             *      这里调用的get方法是java.util.concurrent.FutureTask类的方法，其返回值是RealData类型。它是一个可以获取处理
             * 结果的线程安全的方法。当发生中断时，get方法会抛出InterruptedException异常；当call方法在运行时发生异常时，get方法会
             * 抛出java.util.concurrent.ExecutionException.
             *
             *      get()返回的类型是FutureTask中定义的类型，值为调用call方法返回的值。
             */
            string=get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return string;
    }
}
