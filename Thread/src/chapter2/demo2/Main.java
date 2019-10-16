package chapter2.demo2;

public class Main {

    public static void main(String[] args){
        MutablePerson mutable=new MutablePerson("start","start");
        new CrackerThread(mutable).start();
        new CrackerThread(mutable).start();
        new CrackerThread(mutable).start();
        for (int i=0;true;i++){
            mutable.setPerson(""+i,""+i);
        }
    }
}
