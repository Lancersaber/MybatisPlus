package 第13章String.FormatPrint;

import java.util.Formatter;

/**
 * 在插入数据时，如果想要控制空格与对齐，你需要更精细复杂的格式修饰符。以下是其抽象的语法。
 * %[argument_index$][flags][width][.precision]conversion
 * argument_index$ ==> 数据大小
 * flags ==》 改变对齐方式，默认是左对齐，如果写成"-"则表示右对齐
 * width ==》确保某个域达到至少某个长度
 * precision ==>应用于不同的数据类型会产生不同的效果
 *      String：表示打印String时输出的字符的最大数量
 *      浮点数：表示小数部分要显示出来的位数(默认是6位数)，如果小数位数过多则舍入，太少则补0
 *      整型：触发异常
 */
public class Receipt {
    private double total=0;
    private Formatter f=new Formatter(System.out);

    public void printTitle(){
        f.format("%-15s %5s %10s\n","Item","Qty","Price");
        f.format("%-15s %5s %10s\n","----","---","-----");
    }

    public void print(String name,int qty,double price){
        f.format("%-15.15s %5d %10.2f\n",name,qty,price);
        total+=price;
    }

    public void printTotal(){
        f.format("%-15s %5s %10.2f\n","Tax","",total*0.06);
        f.format("-%15s %5s %10s\n","","","----");
        f.format("%-15s %5s %10.2f\n","Total","",total*1.06);
    }

    public static void main(String[] args){
        Receipt receipt=new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans",4,4.25);
        receipt.print("Princess",3,5.1);
        receipt.printTotal();
    }
}

