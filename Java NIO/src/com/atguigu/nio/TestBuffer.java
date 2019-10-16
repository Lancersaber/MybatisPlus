package com.atguigu.nio;


import java.nio.ByteBuffer;

/**
 * 1、缓冲区(Buffer):在Java NIO中负责数据的存取。缓冲区就是数组，用于存储不同数据类型的数据
 *
 * 根据数据类型不同(boolean 除外)，提供了相应类型的缓冲区
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 2、缓冲区存取数据的核心方法：
 * put():   存入数据到缓冲区中
 * get():   获取缓冲区中的数据
 *
 * 3、缓冲区中的四个核心属性
 * capacity:    容量，表示缓冲区中最大存储数据的容量，一旦声明，不能进行改变
 * limit:       界限，表示缓冲区中可以操作数据的大小(limit 后面的数据不能进行读写)
 * position:    位置，表示缓冲区中正在操作数据的位置。
 *
 * mark:        标记，表示记录当前position的位置，可以通过reset()恢复到mark的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 5、直接缓冲区和非直接缓冲区：
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM 的内存中
 * 直接缓冲区：通过allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class TestBuffer {

    public static void main(String[] args){

//        test03();
        test1();
    }

    public static void test03(){
        //分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        //判断是否为直接缓冲区
        System.out.println(byteBuffer.isDirect());


    }

    public static void test02(){

        String str="abcde";

        ByteBuffer buf=ByteBuffer.allocate(1024);

        buf.put(str.getBytes());

        buf.flip();

        byte[] dst=new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buf.position());

        //mark():标记
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());

        //reset():恢复到mark的位置
        buf.reset();
        System.out.println(buf.position());

        //判断缓冲区是否还有剩余数据
        //hasRemaining()：告诉当前位置和limit之间是否存在任何元素。
        if (buf.hasRemaining()){
            //remaining() :返回当前位置和限制之间的元素数。
            System.out.println(buf.remaining());
        }
    }


    public static void test1(){

        String str="abcde";

        //1.分配一个指定大小得缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("----------------------allocate()---------------------");
        System.out.println("缓冲区中正在操作数据的位置 "+buf.position());
        System.out.println("缓冲区中可以操作数据的大小 "+buf.limit());

        System.out.println("缓冲区中最大存储数据的容量 "+buf.capacity());
        //2、利用put()存入数据到缓冲区中
        buf.put(str.getBytes());
        System.out.println("----------------------put()---------------------");
        System.out.println("缓冲区中正在操作数据的位置 "+buf.position());
        System.out.println("缓冲区中可以操作数据的大小 "+buf.limit());
        System.out.println("缓冲区中最大存储数据的容量 "+buf.capacity());

        //3、切换成读取数据的模式
        buf.flip();
        System.out.println("----------------------flip()---------------------");
        System.out.println("缓冲区中正在操作数据的位置 "+buf.position());
        System.out.println("缓冲区中可以操作数据的大小 "+buf.limit());
        System.out.println("缓冲区中最大存储数据的容量 "+buf.capacity());

        //4、利用get() 读取缓冲区中的数据
        byte[] dst=new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("----------------------get()---------------------");
        System.out.println("缓冲区中正在操作数据的位置 "+buf.position());
        System.out.println("缓冲区中可以操作数据的大小 "+buf.limit());
        System.out.println("缓冲区中最大存储数据的容量 "+buf.capacity());

        //5、rewind():可重复读取数据
        buf.rewind();
        System.out.println("----------------------rewind()---------------------");
        System.out.println("缓冲区中正在操作数据的位置 "+buf.position());
        System.out.println("缓冲区中可以操作数据的大小 "+buf.limit());
        System.out.println("缓冲区中最大存储数据的容量 "+buf.capacity());

        //6、clear():清空缓冲区,但是缓冲区中的数据依然存在，但是处于“被遗忘的状态”
        buf.clear();
        System.out.println("----------------------clear()---------------------");
        System.out.println("缓冲区中正在操作数据的位置 "+buf.position());
        System.out.println("缓冲区中可以操作数据的大小 "+buf.limit());
        System.out.println("缓冲区中最大存储数据的容量 "+buf.capacity());

        System.out.println((char)buf.get());
    }

}
