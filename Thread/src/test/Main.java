package test;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException, InterruptedException {
        String filename="C:\\Users\\34689\\Documents\\Tencent Files\\3468989340\\FileRecv\\WQ_2D_FIG20190406.DAT";
//        String read = read("C:\\Users\\34689\\Documents\\Tencent Files\\3468989340\\FileRecv\\WQ_2D_FIG20190406.DAT",0,1000);
//        System.out.println(read);
//        int length = length(filename);
//        System.out.println(length);


//        Host host=new Host();
//        Data data1 = host.request(filename, 0, 1000);
//        Data data2=host.request(filename,1000,1000);
//        Thread.sleep(500);
//        System.out.println("Data has benn taken");
//        System.out.println(data1.getContent());
//        System.out.println(data2.getContent());

        String read = read(filename, 20);
        System.out.println(read);
    }

    private static int length(String name) throws IOException {
        FileInputStream inputStream=new FileInputStream(name);
        int length=inputStream.available();
        inputStream.close();
        return length;
    }

    public static String read(String filename,int group) throws IOException {
        int length=length(filename);
        Host host=new Host();
        int cap=length/group;
        int last=length%group;
        Data[] datas=new Data[group];
        int skip=0;

        for (int i=0;i<group;i++){
            datas[i]=host.request(filename,skip,cap);
            skip+=cap;
        }
        Data lastData=host.request(filename,skip,last);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<group;i++){
            stringBuilder.append(datas[i].getContent());
        }
        stringBuilder.append(lastData.getContent());
        return stringBuilder.toString();
    }
}
