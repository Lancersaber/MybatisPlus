package chapter12.demo2.ActiveObject;

import chapter12.demo2.MethodRequest.DisplayStringRequest;
import chapter12.demo2.MethodRequest.MakeStringRequest;
import chapter12.demo2.Thread.SchedulerThread;
import chapter12.demo2.result.FutureResult;
import chapter12.demo2.result.Result;

public class Proxy implements ActiveObject {

    private final SchedulerThread scheduler;
    private final Servant servant;

    public Proxy(SchedulerThread scheduler, Servant servant){
        this.scheduler=scheduler;
        this.servant=servant;
    }

    public Result<String> makeString(int count, char fillchar){
        FutureResult<String> future=new FutureResult<>();
        scheduler.invoke(new MakeStringRequest(servant,future,count,fillchar));
        return future;
    }

    @Override
    public void displayString(String string) {
        scheduler.invoke(new DisplayStringRequest(servant,string));
    }
}
