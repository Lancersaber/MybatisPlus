package chapter2;

import java.io.IOException;
import java.net.*;

//输入主机名和端口号进行进行连接，如果成功返回连接主机的主机名和IP地址以及连接所花费的时间
public class ConnectTester {
    public static void main(String[] args){
        String host="localhost";
        String host1="www.baidu.com";
        int port=25;
        int port1=80;
        connect(host1,port1);
    }

    public static void connect(String host,int port){
        SocketAddress remoteAddr=new InetSocketAddress(host,port);
        Socket socket=null;
        String result="";

        try {
            long begin=System.currentTimeMillis();
            socket=new Socket();
            socket.connect(remoteAddr,1000); //超时时间为1s
            long end=System.currentTimeMillis();
            result=(end-begin)+"ms";    //计算连接所花费的时间

            //当Socket的构造方法请求连接服务器时，可能会抛出下面的异常
        } catch (BindException e) { //如果无法把Socket对象与指定的本地IP地址或端口绑定，就会出现这种异常
            result="Local address and port can't be binded!";
        }catch (UnknownHostException e){//如果无法识别主机的名字或IP地址，就会抛出这种异常
            result="Unkownn Host";
        }catch (ConnectException e){//如果没有服务器进程监控指定的端口，或者服务器进程拒绝连接，就会抛出这种异常
            result="Connected Refused";
        }catch (SocketException e){//如果等待连接超时，就会抛出这种异常
            result="TimeOut";
        }catch (IOException e){
            result="failure";
        }
        finally {
            try {
                if (socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(remoteAddr+":"+result);
    }
}
