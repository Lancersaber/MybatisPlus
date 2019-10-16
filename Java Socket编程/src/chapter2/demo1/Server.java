package chapter2.demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println(accept.getLocalAddress()+" "+accept.getLocalPort()+" 连入！");

            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            StringBuilder stringBuilder=new StringBuilder();
            while (s!=null){
                stringBuilder.append(s);
                s=bufferedReader.readLine();
            }
            System.out.println("接收到消息 ："+stringBuilder.toString());
            PrintWriter writer=new PrintWriter(outputStream);
            writer.write("hello");

            inputStream.close();
            outputStream.close();
            bufferedReader.close();
            writer.close();
            accept.close();
        }
    }
}
