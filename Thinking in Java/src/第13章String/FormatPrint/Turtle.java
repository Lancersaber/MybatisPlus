package 第13章String.FormatPrint;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * 在java中，所有新的格式化功能都由java.util.Formatter类处理。可以将Formatter看作一个翻译器，它将你的
 * 格式化字符串与数据翻译成需要的结果。当你创建一个Formatter对象的时候，需要向其他构造器传递一些信息，告诉它最终的
 * 结果将向哪里输出。
 */
public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name,Formatter f){
        this.name=name;
        this.f=f;
    }

    public void move(int x,int y){
        f.format("%s The Turtle is at (%d,%d)\n",name,x,y);
    }

    public static void main(String[] args){
        PrintStream outAlias=System.out;
        Turtle tommy=new Turtle("Tommy",new Formatter(System.out));
        Turtle terry=new Turtle("Terry",new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
    }
}
