package chapter6.demo1;

public class Main {

    public static void main(String[] args){
        Data data=new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data,"ABCDEFGHIGKLMNOPQRSTUVWXYZ").start();
        new WriterThread(data,"ABCDEFGHIGKLMNOPQRSTUVWXYZ".toUpperCase()).start();
    }
}
