package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RealData implements Data {

    private String content;

//    public RealData(String name,int start,int len) throws IOException {
//        FileInputStream fileInputStream=new FileInputStream(name);
//        int size=len;
//        byte[] bytes=new byte[size];
//        try {
//            fileInputStream.read(bytes,start,len);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        content=new String(bytes);
//        fileInputStream.close();
//    }

    public RealData(String name,int skip,int len) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(name);
        byte[] bytes=new byte[len];
        try {
            fileInputStream.skip(skip);
            fileInputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content=new String(bytes);
        fileInputStream.close();
    }

    public void read(String name) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(name);
        int size=fileInputStream.available();
        byte[] bytes=new byte[size];
        try {
            fileInputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content=new String(bytes);
        fileInputStream.close();
    }

    @Override
    public String getContent() {
        return content;
    }


}
