package chapter5.demo2;

import java.util.Random;

public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id=0; //蛋糕的流水号(所有糕点师共用// )

    public MakerThread(String name, Table table, long seed){
        super(name);
        this.table=table;
        random=new Random(seed);
    }

    public void run(){
        try {
            while (true){
                Thread.sleep(random.nextInt(1000));
                String cake="[ Cake No."+nextId()+" by "+getName()+"]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized int nextId(){
        return id++;
    }
}
