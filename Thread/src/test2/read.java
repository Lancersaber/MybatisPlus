package test2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class read {
    public static void main(String[] args) throws IOException {
        String filename="D:\\download\\FLOW0003.DAT";
//        FileReader read=new FileReader(filename);
//        List<String> list=new ArrayList<>();
//        LineNumberReader reader=new LineNumberReader(read);
//        String s=reader.readLine();
//        while (s!=null){
//            list.add(s);
//            s=reader.readLine();
//        }
//        read.close();
//        reader.close();
//        System.out.println(list.size());

//        List<String> read = read(filename, 20);
//        System.out.println(read.size());
//        write("C:\\Users\\34689\\Desktop\\test04.dat",read);

        List<String> read = read("C:\\Users\\34689\\Desktop\\a.txt", 10, 20);
        for (String s:read){
            System.out.println(s);
        }
    }

    public static List<String> read(String filename,int start,int end) throws IOException {
        List<String> list=new ArrayList<>();
        FileReader read=new FileReader(filename);
        LineNumberReader reader=new LineNumberReader(read);
        reader.setLineNumber(start);
        String s=reader.readLine();
        int num=0;
        while (s!=null){
            num=reader.getLineNumber();
            if (start<=num && num<=end){
                list.add(s);
            }else {
                break;
            }
            s=reader.readLine();
        }
        read.close();
        reader.close();
        return list;
    }

    private static int length(String name) throws IOException {
        int length=0;
        FileReader reader=new FileReader(name);
        LineNumberReader lineNumberReader=new LineNumberReader(reader);
        String s=lineNumberReader.readLine();
        while (s!=null){
            length++;
            s=lineNumberReader.readLine();
        }
        reader.close();
        lineNumberReader.close();
        return length;
    }

    public static List<String> read(String filename,int group) throws IOException {
        int length=length(filename);
        System.out.println("文件总长度为"+length);
//        FileReader fileReader=new FileReader(filename);
//        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        int cap=length/group;
        int skip=0;
        int var=cap;
        List<String>[] lists=new ArrayList[group];
        for (int i=0;i<lists.length;i++){
            lists[i]=read(filename,skip,var);
            skip+=cap;
            var+=cap;
        }
        List<String> list=new ArrayList<>();
        for (int i=0;i<lists.length;i++){
            list.addAll(lists[i]);
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
