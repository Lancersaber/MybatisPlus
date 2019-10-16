package 第18章JAVA_IO.输入和输出;

import java.io.*;
import java.util.ArrayList;

/**
 *      缓冲流使用未被处理的数据来填充缓冲区，程序需要数据时，将首先在缓冲区中查找，如果没有找到，再到流源中查找
 * 缓冲字节流是使用BufferedInputStream和BufferedOutStream来表示的。
 * 两种构造方式
 * 1、BufferedInputStream(InputStream in) 创建一个 BufferedInputStream并保存其参数，输入流 in ，供以后使用。
 * 2、BufferedInputStream(InputStream in, int size) 创建 BufferedInputStream具有指定缓冲区大小，并保存其参数，输入流 in ，供以后使用。其中size表示的是多少字节
 */
public class 缓冲流 {

    public static void main(String[] args) throws IOException {
        //简单使用 FileInputStream 和 FileOutputStream
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            //由于java在转义码中使用反斜杠，因此在windows上指定路径时，必须使用\\来替换\
            inputStream=new FileInputStream("C:\\Users\\34689\\Desktop\\1.jpg");
            outputStream=new FileOutputStream("C:\\Users\\34689\\Desktop\\3.jpg");
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            boolean eof=false;//判断文件是否读完
            int count=0;//统计文件的字节数
            ArrayList<Integer> list=new ArrayList<>();
            while (!eof){
                int input=bufferedInputStream.read();
//                System.out.println(input+" ");
                if(input==-1){
                    eof=true;
                }else {
                    list.add(input);
                    count++;
                }
            }
            for (Integer integer:list){
                bufferedOutputStream.write(integer);
            }
//            System.out.println("文件总长为"+count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (outputStream!=null){
                outputStream.close();
            }
            if (bufferedInputStream!=null){
                bufferedInputStream.close();
            }
            if (bufferedOutputStream!=null){
                bufferedOutputStream.close();
            }
        }
    }

}
