package test2;

import java.util.concurrent.Callable;

public class Host {
    public FutureData request(String filename, int start, int end){
//        System.out.println("    request("+count+", "+c+") BEGIN");

        //1、创建FutureData的实例
        FutureData future=new FutureData(
                new Callable<RealData>(){

                    @Override
                    public RealData call() throws Exception {
                        return new RealData(filename,start,end);
                    }
                }
        );

        new Thread(future).start();

//        System.out.println("    request(\"+count+\", \"+c+\") END");

        return future;
    }
}
