package LockSupport_Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Condition_Test {

    public static void main(String[] args){
        test();
    }

    public static void test(){
        ReentrantLock lock=new ReentrantLock();
        //这个变量就是Lock锁对应的一个条件变量，注意，一个Lock对象可以创建多个条件变量
        //lock.newCondition() 的作用其实是new了一个在AQS内部声明的变量
        Condition condition=lock.newCondition();

        lock.lock();
        try {
            System.out.println("begin wait");
            //await()方法阻塞挂起了当前线程。当其他线程调用条件变量的signal方法时，被阻塞的线程才会从await处返回
            //需要注意的是，和调用Object 的wait 方法一样，如果在没有获取到锁前调用了条件变量的await 方法则会抛出
            //java.lang.illegalMonitorStateException
            condition.await();
            System.out.println("end wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        lock.lock();
        try {
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
