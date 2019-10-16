package chapter9.demo1;
//FutureData类是表示“提货单”的类
public class FutureData implements Data {

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
    public synchronized String getContent() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }
}
