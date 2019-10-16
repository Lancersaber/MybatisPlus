package 第13章String.FormatPrint;

import java.util.Formatter;

/**
 * 建立这个类主要目的是熟悉最常用的类型转换
 */
public class FormatConversion {

    public static void main(String[] args){
        Formatter f=new Formatter(System.out);

        char u='a';
        System.out.println("u='a'");
        f.format("s:%s\n",u);
//        f.format("d:%d\n",u);
        f.format("c:%c\n",u);
//        f.format("f:%f\n",u);
        f.format("h:%h\n",u);

        Integer i=0;
        f.format("b:%b\n",i);
    }
}
