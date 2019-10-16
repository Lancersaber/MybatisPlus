package com.atguigu.testBlocking;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用NIO完成网络通信的三个核心：
 * 1、通道(Channel):负责连接
 *
 *      java.nio.channels.Channel 接口：
 *          |-- SelectableChannel
 *              |-- SocketChannel (TCP)
 *              |-- ServerSocketChannel (TCP)
 *              |-- DatagramChannel (UDP)
 *
 *              |-- Pipe.SinkChannel
 *              |-- Pipe.SourceChannel
 *
 * 2、缓冲区(Buffer):负责数据的存取
 *
 * 3、选择器(Selector):是SelectChannel的多路复用器。用于监控SelectableChannel的IO 状况
 */

public class TestBlockingNIO {


    public static void main(String[] args) throws IOException, InterruptedException {
        server();
//        client();
    }



    //服务端
    public static void server() throws IOException {
        //1、获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\10.txt"), StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE);
        //2、绑定连接端口号
        ssChannel.bind(new InetSocketAddress(9898));

        //3、获取客户端连接的通道
        SocketChannel accept = ssChannel.accept();

        //4、分配一个指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //5、接收客户端的数据，并保存到本地
        while (accept.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //6、关闭对应的通道
        ssChannel.close();
        accept.close();
        outChannel.close();
    }
}
