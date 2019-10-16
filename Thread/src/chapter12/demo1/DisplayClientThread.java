package chapter12.demo1;

//DisplayClientThread 类与 MakerClientThread一样，是表示使用ActiveObject 对象的线程的类
//DisplayClientThread 是调用主动对象的displayString方法(显示字符串)的线程
public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;
    public DisplayClientThread(String name,ActiveObject activeObject){
        super(name);
        this.activeObject=activeObject;
    }

    public void run(){
        try {
            for (int i=0;true;i++){
                //没有返回值的调用
                String string=Thread.currentThread().getName()+" "+i;
                activeObject.displayString(string);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
