package anotherChapter2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class read {

    public static void main(String[] args) throws IOException {
        String filename="C:\\Users\\34689\\Desktop\\a.txt";
        FileReader fileReader=new FileReader(filename);
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        lineNumberReader.skip(21);
        String s = lineNumberReader.readLine();
        int length = s.length();
        System.out.println(length);
//        lineNumberReader.skip(length);

        while (s!=null){
            System.out.println(s);
            s=lineNumberReader.readLine();
        }
    }
}
