package 第13章String.FormatPrint;

public class DatabaseException extends Exception {

    public DatabaseException(int transactionId,int queryId,String message){
        //String.format()是一个静态方法，它接收与Formatter.format()方法一样的参数，但返回一个String对象。
        //当你只需要使用format()方法一次的时候，String.format()用起来很方便
        super(String.format("(t%d,q%d)%s",transactionId,queryId,message));
    }

    public static void main(String[] args){
        try {
            throw new DatabaseException(3,7,"Write failed");
        }catch (Exception e){
            System.out.println(e);
        }
        //补偿compensate
    }
}
