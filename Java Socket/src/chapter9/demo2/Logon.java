package chapter9.demo2;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 如果我们正在操作是一个Serializable对象，那么所有序列化操作都会自动进行。为了能够予以控制，可以用transient(瞬时)关键字逐个
 * 字段地关闭序列化，它的意思是"不麻烦你保存或恢复数据--我自己会处理"
 */

//展示transient关键字的作用
public class Logon implements Serializable {
    private Date date=new Date();
    private String username;
    private transient String password;

    public Logon(String name,String password){
        username=name;
        this.password=password;
    }

    @Override
    public String toString() {
        return "logon info: \n  username: "+username+" \n date: "+date+" \n password: "+password;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Logon a=new Logon("Hulk","myLittlePony");
        System.out.println("logon a = "+a);
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1); //Delay

        //Now get them back
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at "+new Date());
        a=(Logon)in.readObject();
        System.out.println("Logon a="+a);
    }
}
