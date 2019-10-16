package chapter4.demo1;

public class Main {

    public static void main(String[] args){
        Data data=new Data("C:\\Users\\34689\\Desktop\\data.txt","(empty)");
        new ChangerThread("ChangerThread",data).start();
        new SaveThread("SaverThread",data).start();
    }
}
