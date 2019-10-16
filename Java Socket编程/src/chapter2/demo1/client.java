package chapter2.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

    }
}
