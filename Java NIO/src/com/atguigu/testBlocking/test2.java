package com.atguigu.testBlocking;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class test2 {
    public static void main(String[] args) throws IOException {
        client2();
    }

    //客户端
    public static void client() throws IOException {
        //1、获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel= FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\1.txt"), StandardOpenOption.READ);

        //2、分配指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //3、读取本地文件并发送到服务端
        while (inChannel.read(buf)!=-1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        //4、关闭通道
        inChannel.close();
        sChannel.close();
    }

    public static void client2() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\1.txt"), StandardOpenOption.READ);

        ByteBuffer buf=ByteBuffer.allocate(1024);

        while (inChannel.read(buf)!=-1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        sChannel.shutdownOutput();

        //接收服务端的反馈
        int len=0;
        while ((len=sChannel.read(buf))!=-1){
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }

        inChannel.close();
        sChannel.close();
    }
}
