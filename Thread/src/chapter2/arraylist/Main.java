package chapter2.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  1、ArrayList类在被多个线程同时读写而失去安全性时，便会抛出java.util.ConcurrentModificationException异常。
 * 该运行时的异常表示“执行并发修改了”
 *
 *  2、java.util.ArrayList是非线程安全的类，但如果使用Collections.synchronizedList方法进行同步，就能够得到线程安全的
 * 实例。
 *
 * 3、使用copy-on-write的java.util.concurrent.CopyOnWriteArrayList类
 *    java.util.concurrent.CopyOnWriteArrayList类是线程安全的。与使用Collections.synchronizedList方法进行的同步不同，
 * CopyOnWriteArrayList类是采用了copy-on-write技术来避免读写冲突的。
 *    所谓copy-on-write，就是“写时复制”的意思。如果使用copy-on-write，当对集合执行“写”操作时，内部已确保安全的数组就
 * 会被整体复制。复制之后，就无需在使用迭代器依次读取元素时担心元素被修改了。
 */

public class Main {

    public static void main(String[] args){
//        List<Integer> list=new ArrayList<>();
//        final List<Integer> list= Collections.synchronizedList(new ArrayList<>());
        final List<Integer> list=new CopyOnWriteArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
