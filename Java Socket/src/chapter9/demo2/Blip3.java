package chapter9.demo2;

import java.io.*;

public class Blip3 implements Externalizable {

    private int i;
    private String s;//No initialization
    public Blip3(){
        System.out.println("Blip3 Construction");
        // s, i not initialized
    }

    public Blip3(String x,int a){
        System.out.println("Blip3(String x,int a)");
        s=x;
        i=a;
        // s & i initialized only in non-default constructor
    }

    public String toString(){
        return s+i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        //You must do this
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        //You must do this:
        s= (String) in.readObject();
        i=in.readInt();
    }

    /**
     *      在本例中，字段s和i只在第二个构造器中初始化，而不是在默认的构造器中初始化。这意味着假如不在readExternal()中初始化s和i，
     * s就会为null，而不是0(因为在创建对象的第一步中将对象的存储空间清理为0).如果注释掉跟随于"You must do this"后面的两行代码，
     * 然后运行程序，就会发现当对象被还原后，s是null，而i是零
     *      将类实现为Externalizable，这样一来，没有任何东西可以自动序列化，并且可以在writeExternal()内部只对所需部分进行显示的序列化。
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip3 b3=new Blip3("A String",47);
        System.out.println(b3);

        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();
        //Now get it back
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3:");
        b3= (Blip3) in.readObject();
        System.out.println(b3);
    }
}
