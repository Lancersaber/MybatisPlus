package chapter2;

import java.net.*;
import java.util.Enumeration;

public class InetAddressExample {

    public static void main(String[] args) throws UnknownHostException {
//        showInetAddress();
//        InetAddress[] byName = InetAddress.getAllByName("www.baidu.com");
//        for (InetAddress address:byName){
//            System.out.println("\t"+address.getHostName()+" / "+address.getHostAddress());
//        }

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("主机名称为 ："+localHost.getHostName());
        System.out.println("分配的IP地址为："+localHost.getHostAddress());
        System.out.println(localHost.toString());
        byte[] address = localHost.getAddress();
        for (byte b:address){
            System.out.print(b);
        }
    }

    public static void showInetAddress(){
        try {
            //Get the network interfaces and associated address for this host
            //NetworkInterface 类提供了访问主机所有接口信息的功能
            Enumeration<NetworkInterface> interfaceList=NetworkInterface.getNetworkInterfaces();

            if (interfaceList==null){
                System.out.println("No interfaces found!");
            }else {
                while (interfaceList.hasMoreElements()){
                    NetworkInterface networkInterface = interfaceList.nextElement();
                    System.out.println("Interface "+networkInterface.getName()+":");
                    //使用绑定到此网络接口的 InetAddresses全部或一部分子枚举的枚举方法。
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    if (!inetAddresses.hasMoreElements()){
                        System.out.println("\t(No Address for this interface)");
                    }
                    while (inetAddresses.hasMoreElements()){
                        InetAddress inetAddress = inetAddresses.nextElement();
                        System.out.println("\tAddress "+((inetAddress instanceof Inet4Address)?"v4":"v6"));
                        System.out.println(" : "+inetAddress.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("Error getting network interfaces:");
            e.printStackTrace();
        }
    }
}
