package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data {

    public FutureData(Callable<RealData> callable){
        super(callable);
    }

    @Override
    public List<String> getContent() {
        List<String> list=new ArrayList<>();
        try {
            list=get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return list;
    }
}