package test2;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RealData implements Data {

    private static String lock="lock";
    private List<String> list=new ArrayList<>();


    public RealData(String name,int start,int end) throws IOException {
        synchronized (lock){
            FileReader reader=new FileReader(name);
            LineNumberReader lineNumberReader=new LineNumberReader(reader);
//            lineNumberReader.setLineNumber(start);
            String s=lineNumberReader.readLine();
            while (s!=null){
                int lineNumber = lineNumberReader.getLineNumber();
                if (start<=lineNumber && end>=lineNumber){
//                    String[] split = s.trim().split("\\s+");
//                    if (split.length==25){
//                        list.addAll(Arrays.asList(split));
//                    }
                    list.add(s);
                }
                if (end<lineNumber){
                    break;
                }
                s=lineNumberReader.readLine();
            }
            reader.close();
            lineNumberReader.close();
        }
    }


    @Override
    public List<String> getContent() {
        return list;
    }


}
