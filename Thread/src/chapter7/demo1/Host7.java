package chapter7.demo1;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *      java.util.concurrent.ScheduledExecutorService接口是ExecutorService的子接口，用于推迟操作的执行
 *
 */
public class Host7 {
    private final Helper helper=new Helper();
    private final ScheduledExecutorService scheduledExecutorService;

    public Host7(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void request(final int count,final char c){
        System.out.println("     handle("+count+","+c+") BEGIN");

        //这个函数用于设置Runnable对象(r)和延迟时间(delay,unit)
        //schedule(Runnable r,long delay,TimeUnit unit)

        //这个函数表示请求到达约3秒之后再执行
        scheduledExecutorService.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count,c);
                    }
                },
                3L,
                TimeUnit.SECONDS
        );

        System.out.println("     handle("+count+","+c+") END");
    }
}
