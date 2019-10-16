package chapter4.demo1;

import java.io.IOException;
import java.util.Random;
//用于修改并保存数据的ChangerThread类
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random=new Random();

    public ChangerThread(String name,Data data){
        super(name);
        this.data=data;
    }

    public void run(){
        try {
            for (int i=0;true;i++){
                data.change("No."+i); //修改数据
                Thread.sleep(random.nextInt(1000));//执行其他操作
                data.save();    //显示地保存
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
