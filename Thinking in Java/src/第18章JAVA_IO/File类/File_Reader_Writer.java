package 第18章JAVA_IO.File类;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File_Reader_Writer {

    public static void main(String[] args) throws IOException {
        String filePath="D:\\IOTest\\1.txt";
        String s = readFile(filePath);
        System.out.println(s);
    }

    public static String readFile(String fileName) throws IOException {
        FileReader reader=null;
        StringBuilder stringBuilder=new StringBuilder();
        try {
            reader=new FileReader(fileName);
            int i=0;
            while (i!=-1){
                i=reader.read();
                stringBuilder.append((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }

        return stringBuilder.toString();
    }

    public static void writeFile(String fileName){

    }
}
