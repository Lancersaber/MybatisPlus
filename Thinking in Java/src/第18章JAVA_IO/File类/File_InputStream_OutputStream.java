package 第18章JAVA_IO.File类;

import 第15章泛型.generatorTest.CountingGenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_InputStream_OutputStream {

    public static void main(String[] args) throws IOException {
        String s = File_InputStream_OutputStream.readFile("D:\\IOTest\\buhuo1.PNG");
        System.out.println(s);
    }


    public static String readFile(String filname) throws IOException {
        StringBuilder stringBuffer=new StringBuilder();
        String s="";
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(filname);
            int available = fileInputStream.available();
            System.out.println("可读取的字节数为 "+available);
            byte[] bytes=new byte[available];
            fileInputStream.read(bytes);
            writeFile("D:\\IOTest\\2.PNG",bytes);
            stringBuffer.append(bytes);
            s=new String(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到指定文件");
        }
        finally {
            fileInputStream.close();
        }

        return stringBuffer.toString();
//        return s;
    }

    //把数据写入指定的文件
    public static void writeFile(String fileName,byte[] bytes) throws IOException {
        FileOutputStream outputStream=null;

        try {
            outputStream=new FileOutputStream(fileName);
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }


}
