package com.atguigu.nio;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 *  通道(Channel):由java.nio.channels包定义。Channel类似于传统的"流"。只不过Channel
 *  本身不能直接访问数据，Channel只能与Buffer进行交互。
 */

/**
 * 1、通道(channel) : 用于源结点与目标结点的连接。在Java NIO中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合
 * 缓冲区进行传输。
 *
 * 2、通道的主要实现类
 *  java.nio.channels.Channel 接口：
 *      -- FileChannel
 *      -- SocketChannel
 *      -- ServerSocketChannel
 *      -- DatagramChannel
 *
 * 3、获取通道
 * a、Java 针对支持通道的类提供了getChannel()方法
 *      本地IO：
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络IO：
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 * b、在JDK1.7中的 NIO.2 针对各个通道提供了静态方法 open()
 * c、在JDK1.7中的 NIO.2 的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输(直接缓冲区)
 * transferFrom()
 * transferTo()
 *
 * 五分散(Scatter)与聚集(Gather)
 * 分散读取(Scatter Reads):将通道中的数据分散到多个缓冲区中
 * 聚集写入(Gathering Writes):将多个缓冲区中的数据聚集到通道中
 *
 * 六字符集(CharSet)
 * 编码：字符串--》字节数组
 * 解码：字节数组--》字符串
 */
public class TestChannel {

    public static void main(String[] args) throws IOException {
//        test01();
//        test03();
//        test05();
        test06();
    }


    public static void test06() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器与解码器
        //获取编码器
        CharsetEncoder charsetEncoder = cs1.newEncoder();

        //获取解码器
        CharsetDecoder charsetDecoder = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("尚硅谷威武！");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = charsetEncoder.encode(cBuf);
        for (int i=0;i<12;i++){
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer decode = charsetDecoder.decode(bBuf);
        System.out.println(decode.toString());

        System.out.println("-------------------------");
        //按照gbk编码，使用utf-8解码情况
        Charset charset = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer decode1 = charset.decode(bBuf);
        System.out.println(decode1.toString());
    }

    //获取所有支持的编码方式
    public static void test05(){
        SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();

        for (Map.Entry<String,Charset> entry:entries){
            System.out.println(entry.getValue());
        }
    }

    public static void test04() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("C:\\Users\\34689\\Desktop\\1.txt","rw");

        //1、获取通道
        FileChannel channel1=raf1.getChannel();

        //2、分配指定大小的缓冲区
        ByteBuffer buf1=ByteBuffer.allocate(100);
        ByteBuffer buf2=ByteBuffer.allocate(1024);
//        ByteBuffer buf3=ByteBuffer.allocate(100);

        //3、分散读取
        ByteBuffer[] bufs={buf1,buf2};
        channel1.read(bufs);

        for (ByteBuffer buffer:bufs){
            buffer.flip();
        }

        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("--------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        //4、聚集写入
        RandomAccessFile raf2=new RandomAccessFile("C:\\Users\\34689\\Desktop\\6.txt","rw");
        FileChannel channel = raf2.getChannel();
        channel.write(bufs);
        channel.close();

    }

    public static void test03() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\1.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\5.txt"), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.READ);

//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    //2、使用直接缓冲区完成文件的复制(内存映射文件的方式)
    public static void test02() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\1.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\34689\\Desktop\\3.txt"), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.READ);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作(不用借助于通道来进行传输)
        byte[] dst=new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }

    //1、利用通道完成文件的复制（使用非直接缓冲区）
    public static void test01() throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\34689\\Desktop\\1.txt");
        FileOutputStream fos=new FileOutputStream("C:\\Users\\34689\\Desktop\\2.txt");

        //1、获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        //2、分配指定大小的缓冲区域
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //3、将通道中的数据存入缓冲区中
        while (inChannel.read(buffer)!=-1){
            buffer.flip();//切换读取数据的模式

            //4、将缓冲区中的数据写入通道中
            outChannel.write(buffer);
            buffer.clear();//清空缓冲区
        }

        outChannel.close();
        inChannel.close();
        fis.close();
        fos.close();
    }
}
