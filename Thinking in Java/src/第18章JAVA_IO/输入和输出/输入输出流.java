package 第18章JAVA_IO.输入和输出;

import java.io.*;

/**
 * InputStream:所有字节输入流的父类
 * OutputStream：所有字节输出流的父类
 */
public class 输入输出流 {
    public static void main(String[] args) throws IOException {
//        //简单使用 FileInputStream 和 FileOutputStream
//        FileInputStream inputStream=null;
//        FileOutputStream outputStream=null;
//        try {
//            //由于java在转义码中使用反斜杠，因此在windows上指定路径时，必须使用\\来替换\
//            inputStream=new FileInputStream("C:\\Users\\34689\\Desktop\\1.txt");
//            outputStream=new FileOutputStream("C:\\Users\\34689\\Desktop\\2.txt");
//            boolean eof=false;//判断文件是否读完
//            int count=0;//统计文件的字节数
//            ArrayList<Integer> list=new ArrayList<>();
//            while (!eof){
//                int input=inputStream.read();
////                System.out.println(input+" ");
//                if(input==-1){
//                    eof=true;
//                }else {
//                    list.add(input);
//                    count++;
//                }
//            }
//            for (Integer integer:list){
//                outputStream.write(integer);
//            }
////            System.out.println("文件总长为"+count);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            if (inputStream!=null){
//                inputStream.close();
//            }
//            if (outputStream!=null){
//                outputStream.close();
//            }
//        }
        test();
    }

    /**
     * 字符流
     * Reader：所有字符输入流的父类
     * Writer：所有字符输出流的父类
     */
    /**
     * 几个重要的字符流
     * 1、BufferedReader
     * 从字符输入流读取文本，缓冲字符，以提供字符，数组和行的高效读取。
     * 可以指定缓冲区大小，或者可以使用默认大小。 默认值足够大，可用于大多数用途。
     * 将缓冲指定文件的输入。 没有缓冲，每次调用read（）或readLine（）可能会导致从文件中读取字节，转换成字符，然后返回，这可能非常低效。
     *
     * BufferedReader(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流。
     * BufferedReader(Reader in, int sz) 创建使用指定大小的输入缓冲区的缓冲字符输入流。
     *
     * 2、InputStreamReader是从字节流到字符流的桥：
     * 它读取字节，并使用指定的charset将其解码为字符 。 它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集。
     * 每个调用InputStreamReader的read（）方法之一可能会导致从底层字节输入流读取一个或多个字节。 为了使字节有效地转换为字符，可以从底层流读取比满足当前读取操作所需的更多字节。
     *
     * 为了最大的效率，请考虑在BufferedReader中包装一个InputStreamReader。 例如
     *  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     */
    public static void test() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s="";
        try {
            do {
               System.out.println("请输入内容");
               s=bufferedReader.readLine();
               if (!("".equals(s))){
                   System.out.println("输入的表达式为"+s);
               }else {
                   System.out.println("结束");
               }
            }while (!("".equals(s)));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                bufferedReader.close();
            }
        }
    }
}
