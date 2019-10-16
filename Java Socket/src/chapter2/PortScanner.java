package chapter2;

import java.io.IOException;
import java.net.Socket;

/**
 * 1、Socket的构造方法共有五种，除了不带参数的构造参数外，其他构造参数都会试图建立与服务器的连接，如果连接不成功，就返回Socket对象，
 * 如果因为某些原因连接失败，就会抛出IOException。
 */

/**
 * 这个类的作用主要是查看本机1-1023号端口哪些在监听
 */
public class PortScanner {

    public static void main(String[] args){
        String host="localhost";
        scan(host);
    }

    public static void scan(String host) {
        Socket socket=null;
        for (int port=1;port<1024;port++){
            try {
                socket=new Socket(host,port);
                System.out.println("There is a server on port "+port);
            } catch (IOException e) {
                System.out.println("Can't connect to port"+port);
            }finally {
                try {
                    if (socket!=null)
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
