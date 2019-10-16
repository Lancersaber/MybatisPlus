package chapter6.demo1;


public class ReadWriteLock {
    private int readingReaders=0; //实际正在读取中的线程个数，也就是执行了readLock,但尚未执行readUnlock的线程数
    private int waitingWriters=0; //正在等待写入的线程个数，也就是执行了writeLock之后，使用wait执行等待的线程的个数。
    private int writingWriters=0; //实际正在写入中的线程个数。也就是执行了writeLock之后，但尚未执行writeUnLock的线程的个数(只能是0 或 1 )
    private boolean preferWriter=true; //若写入优先，则为true

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters>0 || (preferWriter && waitingWriters>0)){
            wait();
        }
        readingReaders++; //实际正在读取的线程个数加1
    }

    public synchronized void readUnlock(){
        readingReaders--;//实际正在读取的线程个数减1
        preferWriter=true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++; //正在等待读取写入的线程个数加1
        try {
            while (readingReaders>0 || writingWriters>0){
                wait();
            }
        } finally {
            //说明既没有线程读也没有线程写入的时候，这个线程进行写入操作
            waitingWriters--; //正在等待写入的线程个数减一
        }
        writingWriters++; //实际正在写入的线程个数加1
    }

    public synchronized void writeUnlock(){
        writingWriters--; //实际正在写入的线程个数减1
        preferWriter=false;
        notifyAll();
    }
}
