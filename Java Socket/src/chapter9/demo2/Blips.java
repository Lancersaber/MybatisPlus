package chapter9.demo2;

import java.io.*;

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1=new Blip1();
        Blip2 b2=new Blip2();
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        //Now get them back
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1= (Blip1) in.readObject();

        //Throw an Exception
//        System.out.println("Recovering b2");
//        b2= (Blip2) in.readObject();

        /**
         *      这里没有恢复Blip2对象，因为那样做会产生一个异常。Blip1的构造器是public,Blip2的构造器却不是，这样就会在恢复时造成异常。
         *      恢复b1后，会调用Blip1默认构造器。这与恢复一个Serializable对象不同。对于Serializable对象，对象完全以它存储的二进制为基础
         * 来构造，而不是调用构造器。然而对于一个Externalizable对象来说，所有普通的默认构造器都会被调用(包括在字段定义时的初始化)，然后调用
         * readExternal().
         *      必须注意这一点--- 所有的默认构造器都会被调用，才能使Externalizable对象产生正确的行为。
         */
    }
}

class Blip1 implements Externalizable{

    public Blip1(){
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable{

    Blip2(){
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}