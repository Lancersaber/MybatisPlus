package chapter4.demo1;

import java.io.IOException;
//定期要求保存数据的SaverThread 类
public class SaveThread extends Thread {
    private final Data data;

    public SaveThread(String name,Data data){
        super(name);
        this.data=data;
    }

    public void run(){
        try {
            while (true){
                data.save(); //要求保存数据
                Thread.sleep(1000);
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
