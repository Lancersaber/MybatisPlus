package com.lancer.Easy;

import java.util.Vector;

public class BitCount {
    private static int COUNT_BITS = Integer.SIZE - 3;
    private static int CAPACITY   = (1 << COUNT_BITS) - 1;;

    public static void main(String[] args){

        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;

        //Java提供的位运算符有：左移( << )、右移( >> ) 、无符号右移( >>> ) 、位与( & ) 、位或( | )、位非( ~ )、位异或( ^ )，除了位非( ~ )是一元操作符外，其它的都是二元操作符。
        //左移运算符，将5 左移 2 位
        System.out.println(5<<2);

        //右移运算符，将 5 右移 2 位
        System.out.println(5>>2);

        //位与运算符，第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
        System.out.println(5 & 3);

        //位或运算符，第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
        System.out.println(5|3);

        //位异或( ^ ):第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
        System.out.println(3 ^ 3);

        System.out.println("COUNT_BITS: "+COUNT_BITS);
        System.out.println("CAPACITY: "+CAPACITY);
        System.out.println("RUNNING: "+RUNNING);
        System.out.println("SHUTDOWN: "+SHUTDOWN);
        System.out.println("STOP: "+STOP);
        System.out.println("TIDYING: "+TIDYING);
        System.out.println("TERMINATED: "+TERMINATED);

        int i = ctlOf(RUNNING, 0);
        System.out.println(i);
        int i1 = runStateOf(i);
        System.out.println(i1);
        int i2 = workerCountOf(i);
        System.out.println(i2);

        System.out.println(1<<3);
    }

    private static int ctlOf(int rs, int wc) { return rs | wc; }
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
}
