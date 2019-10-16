package LockSupport_Test;

import java.util.concurrent.locks.LockSupport;

/**
 * 运行 test1() 函数会发现最终只会输出begin park！然后当前线程被挂起，这是因为
 * 在默认情况下调用线程是不持有许可证的。
 */
public class Main {

    public static void main(String[] args){
        Main main=new Main();
        main.test1();
    }

    public void test1(){
        System.out.println("Begin park!");
        LockSupport.park(this);
        System.out.println("End park!");
    }

    public static void test2(){
        System.out.println("Begin park!");
        //使当前线程获取许可证
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("End park!");
    }
}
