package chapter5.demo2;

public class Main {

    public static void main(String[] args){
        Table table=new Table(3); //创建一个能放置3个蛋糕的桌子
        new MakerThread("MakerThread-1",table,31415).start();
        new MakerThread("MakerThread-2",table,9527).start();
        new MakerThread("MakerThread-3",table,131421).start();
        new EaterThread("EaterThread-1",table,44444444).start();
        new EaterThread("EaterThread-2",table,555555).start();
        new EaterThread("EaterThread-3",table,666666).start();
    }


}
