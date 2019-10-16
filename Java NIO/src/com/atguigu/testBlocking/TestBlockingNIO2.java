package com.atguigu.testBlocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO2 {

    public static void main(String[] args) throws IOException {
        server();
    }

    public static void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.bind(new InetSocketAddress(9898));

        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\9.txt"), StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE);

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf=ByteBuffer.allocate(1024);
        while (sChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //发送反馈给客户端
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();
        sChannel.write(buf);


        sChannel.close();
        ssChannel.close();
        outChannel.close();
    }
}
