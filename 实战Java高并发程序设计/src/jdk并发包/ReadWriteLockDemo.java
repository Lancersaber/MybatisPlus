package jdk并发包;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private static Lock lock=new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private static Lock readLock=readWriteLock.readLock();
    private static Lock writeLock=readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock){
        try {
            lock.lock();//模拟读操作
            System.out.println("value = "+value);
            Thread.sleep(1000); //读操作的耗时越多，读写锁的优势越明显
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public void handleWrite(Lock lock,int index){
        lock.lock();
        try {
            Thread.sleep(1000);//模拟写操作
            value=index;
            System.out.println("In write : value = "+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final ReadWriteLockDemo demo=new ReadWriteLockDemo();
        Runnable readRunnable=new Runnable() {
            @Override
            public void run() {
                demo.handleRead(readLock);
//                demo.handleRead(lock);
            }
        };
        Runnable writeRunnable=new Runnable() {
            @Override
            public void run() {
                demo.handleWrite(writeLock,new Random().nextInt());
//                demo.handleWrite(lock,new Random().nextInt());
            }
        };

        for (int i=0;i<18;i++){
            new Thread(readRunnable).start();
        }

        for (int i=0;i<2;i++){
            new Thread(writeRunnable).start();
        }
    }


}
