package chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *      服务器端的工作是建立一个通信终端，并被动地等待客户端的连接。典型的TCP服务器执行如下两步工作。
 *
 *      1、创建一个ServerSocket实例并指定本地端口。此套接字的功能是侦听该指定端口收到的连接。
 *      2、重复执行：
 *      a、调用ServerSocket的accept()方法以获取下一个客户端连接。基于新建立的客户端连接，创建一个Socket实例，
 *      并由accept()方法返回。
 *      b、使用返回后的Socket实例的InputStream和OutputStream与客户端进行通信
 *      c、通信完成后，使用Socket类的close()方法关闭该客户端套接字连接
 */
public class TCPEchoServer {

    private static final int BUFSIZE=32;// Size of receive buffer

    public static void main(String[] args){

    }

    public static void server(String[] args) throws IOException {
        if (args.length!=1){
            throw new IllegalArgumentException("参数不正确");
        }

        int serverPort=Integer.parseInt(args[0]);

        //Create a server socket to client connection requests
        ServerSocket serverSocket=new ServerSocket(serverPort);

        int recvMsgSize;    // Size of received message
        byte[] reveiveBuf=new byte[BUFSIZE];    //Receive buffer

        while (true){   //Run forever,accepting and servicing connections
            Socket clntSocket=serverSocket.accept();    // Get client connection

            //getRemoteSocketAddress()方法返回了一个包含了客户端地址和端口号的InetSocketAddress实例
            SocketAddress clientAddress=clntSocket.getRemoteSocketAddress();
            System.out.println("Handling client at "+clientAddress);

            InputStream in=clntSocket.getInputStream();
            OutputStream out=clntSocket.getOutputStream();

            //Receive until client closes connection,indicated by -1 return
            while ((recvMsgSize=in.read(reveiveBuf))!=-1){
                out.write(reveiveBuf,0,recvMsgSize);
            }
            clntSocket.close(); // Close the socket. We are done with this client!
        }
    }
}
