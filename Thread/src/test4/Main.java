package test4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String filename="D:\\download\\FLOW0003.DAT";

        long l = System.currentTimeMillis();
        List<String[]> read = read(filename, 20);

//        write("C:\\Users\\34689\\Desktop\\test.dat",read);
        long l1 = System.currentTimeMillis();
        System.out.println((l1-l)/1000.0);
        System.out.println(read.size());
    }

    //返回文件总共有多少行
    private static int length(String name) throws IOException {
        int length=0;
        FileReader reader=new FileReader(name);
        LineNumberReader lineNumberReader=new LineNumberReader(reader);
        String s=lineNumberReader.readLine();
        while (s!=null){
            length++;
            s=lineNumberReader.readLine();
        }
        return length;
    }


    public static List<String[]> read(String filename, int group) throws IOException, InterruptedException {
        int length=length(filename);
//        System.out.println("文件总共有 "+length+" 行");
        Host host=new Host();
        int cap=length/group;
//        System.out.println("创建"+group+" 个线程，每个线程读取"+cap+" 行");
        int variable=cap;
        int plus=length%group;

        int last=length;

        Data[] datas=new Data[group];
        int skip=1;
        for (int i=0;i<group;i++){
            datas[i]=host.request(filename,skip,variable);
//            System.out.println(i+" -> skip="+skip+" cap="+variable);
            skip+=cap;
            variable+=cap;
        }
        Data lastData=null;
        if (plus!=0){
//            System.out.println("skip="+skip+" last="+last);
            lastData=host.request(filename,skip,last);
        }
//        Thread.sleep(1000);
        List<String[]> list=new ArrayList<>();
        for (int i=0;i<group;i++){
//            if (datas[i]==null){
//                System.out.println("Error!!");
//            }
//            System.out.println(i+" -> "+datas[i].getContent().size());
            list.addAll(datas[i].getContent());
        }
        if (lastData!=null){
//            System.out.println("lastData->"+lastData.getContent().size());
            list.addAll(lastData.getContent());
        }
        return list;
    }

    public static void write(String filename,List<String> list) throws IOException {
        FileWriter fileWriter=new FileWriter(filename);
        for (String s:list){
            if (s!=null){
                fileWriter.write(s+"\n");
            }
        }
        fileWriter.close();
    }
}
