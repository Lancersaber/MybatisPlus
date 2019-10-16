package com.atguigu.TestNonBlockingNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class TestNonBlockingNIO {


    public static void main(String[] args) throws IOException {
        client();
    }

    //客户端
    public static void client() throws IOException {
        //1、获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //2、切换成非阻塞模式
        sChannel.configureBlocking(false);

        //3、分配一个指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //4、发送数据给服务器
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.next();
            buf.put((new Date().toString()+"\n"+str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }



        //5、关闭通道
        sChannel.close();
    }
}
