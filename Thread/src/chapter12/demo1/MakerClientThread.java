package chapter12.demo1;

//MakerClientThread类是调用主动对象的makeString方法
public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerClientThread(String name,ActiveObject activeObject){
        super(name);
        this.activeObject=activeObject;
        this.fillchar=name.charAt(0);
    }

    public void run(){
        try {
            for (int i=0;true;i++){
                //有返回值的调用
                Result<String> result=activeObject.makeString(i,fillchar);
                Thread.sleep(10);
                String value=result.getResultValue();
                System.out.println(Thread.currentThread().getName()+": value = "+value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
