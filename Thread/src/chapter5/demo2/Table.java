package chapter5.demo2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 这个类在这个例子中充当守护安全性的Channel角色(可复用性)
 *
 */
public class Table extends ArrayBlockingQueue<String> {


    public Table(int count) {
        super(count);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" puts "+cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake= super.take();
        System.out.println("        "+Thread.currentThread().getName()+" takes "+cake);
        return cake;
    }
}
