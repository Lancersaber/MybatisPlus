package test3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int[] skips=new int[21];

    public static void main(String[] args) throws IOException, InterruptedException {
        String filename="D:\\download\\FLOW0003.DAT";

        long l = System.currentTimeMillis();
        List<String[]> read = read(filename, 20);

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
        readSkips("C:\\Users\\34689\\Desktop\\count.txt");
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
            if (skips[i]==0){
                datas[i]=host.request(filename,skip,variable,0);
            }
            else {
                datas[i]=host.request(filename,skip,variable,skips[i]);
            }
            skip+=cap;
            variable+=cap;
        }
        Data lastData=null;
        if (plus!=0){
            lastData=host.request(filename,skip,last,skips[group]);
        }

        List<String[]> list=new ArrayList<>();

        for (int i=0;i<group;i++){
            if (skips[i+1]==0){ //如果是第一次读取，则skips[i+1]=0,此时需要将skips[i+1]的值更新
                skips[i+1]=datas[i].getContent().getLength();
            }
            list.addAll(datas[i].getContent().getList());
        }

        if (lastData!=null){
//            System.out.println("lastData->"+lastData.getContent().size());
            list.addAll(lastData.getContent().getList());
        }

        //将得到的skips数组写入到文件中
        int index=0;
        List<String> count=new ArrayList<>();
        for (Integer i:skips){
            count.add(i.toString());
        }
        String skipfile="C:\\Users\\34689\\Desktop\\count.txt";
        File file=new File(skipfile);
        if (!file.exists()){
            write(skipfile, count);
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

    private static void readSkips(String filename) throws IOException {
        File file=new File(filename);
        boolean exists = file.exists();
        if (!exists){
            return;
        }
        FileReader fileReader=new FileReader(filename);
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        String s = lineNumberReader.readLine();
        int row=lineNumberReader.getLineNumber();
        while (s!=null){
            skips[row]=Integer.parseInt(s);
            row=lineNumberReader.getLineNumber();
            s=lineNumberReader.readLine();
        }
        fileReader.close();
        lineNumberReader.close();
    }
}
