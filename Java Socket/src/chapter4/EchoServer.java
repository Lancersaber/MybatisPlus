package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private int port=8000;
    private ServerSocketChannel serverSocketChannel=null;
    private ExecutorService executorService;    // 线程池
    private static final int POOL_MULTIPLE=4;   // 线程池中工作线程的数目

    public EchoServer() throws IOException {
        //创建一个线程池
        executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_MULTIPLE);

        //创建一个ServerSocketChannel对象
        serverSocketChannel=ServerSocketChannel.open();

        //使得在同一个主机上关闭了服务器程序，紧接着再启动该服务器程序时，可以顺利绑定到相同的端口
        serverSocketChannel.socket().setReuseAddress(true);

        //把服务器进程与一个本地端口绑定
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        System.out.println("服务器启动");
    }

    public void service(){
        while (true){
            SocketChannel socketChannel=null;
            try {
                socketChannel=serverSocketChannel.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

class Handler implements Runnable{
    private SocketChannel socketChannel;

    public Handler(SocketChannel socketChannel){
        this.socketChannel=socketChannel;
    }

    public void handle(SocketChannel socketChannel){
        try {
            Socket socket=socketChannel.socket(); //获得与socketChannel关联的Socket对象
            System.out.println("接收到客户端连接，来自："+socket.getInetAddress()+":"+socket.getPort());


        }finally {

        }
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream,true);
    }

    @Override
    public void run() {

    }
}
