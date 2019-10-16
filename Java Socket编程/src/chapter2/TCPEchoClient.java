package chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 *      Java 为 TCP 协议提供了两个类，Socket类和ServerSocket类。一个Socket实例代表了TCP连接的一端。
 * 一个TCP连接(TCP connection)是一条抽象的双向信道，双端分别由IP地址和端口号确定。在开始通信之前，要建立
 * 一个TCP连接，这需要先由客户端TCP向服务器TCP发送连接请求。ServerSocket实例则监听TCP连接请求，并为每个请求
 * 创建新的Socket实例。
 *      也就是说，服务器端要同时处理ServerSocket实例和Socket实例，而客户端只需要使用Socket实例。
 */
public class TCPEchoClient {
    public static void main(String[] args) throws IOException {
        String[] strings={"192.0.2.1","Echo this"};
        link(strings);
    }

    public static void link(String[] args) throws IOException {
        if ((args.length<2)||(args.length>3)){ //测试传入的参数个数是否正确
            throw new IllegalArgumentException("参数的个数不正确");
        }

        String server=args[0]; //Server name or IP address
        //Convert argument String to bytes using the default character encoding
        byte[] data=args[1].getBytes();
        int serverPort=(args.length==3)?Integer.parseInt(args[2]):7;

        //Create socket that is connected to server on specified port
        Socket socket=new Socket(server,serverPort);
        System.out.println("Connected to server ... sending echo string");

        InputStream in=socket.getInputStream();
        OutputStream out=socket.getOutputStream();

        //通过将字节写入套接字的OutputStream来发送数据，并通过从InputStream读取信息来接收数据
        out.write(data);//send the encoded string to the server

        //Receive the same string back from the server
        int totalBytesRcvd=0; //Total bytes received so far
        int bytesRcvd;        //Bytes received in last read

        while (totalBytesRcvd<data.length){
            if ((bytesRcvd=in.read(data,totalBytesRcvd,data.length-totalBytesRcvd))==-1){
                throw new SocketException("Connection closed prematurely");
            }

            System.out.println("Received: "+new String(data));

            socket.close();
        }
    }
}
