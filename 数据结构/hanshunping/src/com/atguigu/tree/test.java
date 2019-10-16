package com.atguigu.tree;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        //给下面四个定义的变量一个初始值，为null。不给的话在finally中无法close
        FileInputStream input = null;
        FileOutputStream output=null;
        InputStreamReader reader=null;
        BufferedReader bufferedReader=null;
        OutputStreamWriter iwriter=null;
        boolean result=true;
        ArrayList<Integer> list=new ArrayList<>();
        int count=0;
        int i=0;
        try {
            input=new FileInputStream("C:\\Users\\34689\\Desktop\\1.jpg");
            reader=new InputStreamReader(input,"UTF-8");
            while(i!=-1) {
                i=(int) input.read();
                //这里判断一下i是否为-1，如果是-1，则不加入list中
                if (i!=-1){
                    list.add(i);
                }
                count++;
            }
//            System.out.println(list);
            output=new FileOutputStream("C:\\Users\\34689\\Desktop\\4.jpg");
            iwriter=new OutputStreamWriter(output,"UTF-8");
            System.out.println("记事本连接成功");
            for(int o=0;o<list.size();o++) {
                //把iwriter改成output即可
                output.write(list.get(o));
//                System.out.println(list.get(o));
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//添加finally部分代码，关闭所有的流
            if (input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output!=null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

