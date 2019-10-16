package chapter9.demo2;

import java.io.*;

/**
 *      如果不是特别坚持实现Externalizable接口，那么还有一种方法。我们可以实现Serializable接口，并添加(注意，这里是添加，并非"覆盖"或者实现)
 * 名为writeObject() 和 readObject()的方法。这样一旦对象被序列化或者被反序列化还原，就会自动地分别调用这两个方法。也就是说，只要我们提供了这
 * 两个方法，就会使用它们而不是默认的序列化机制。
 *
 * 这些方法必须具有准确的方法特征签名
 * private void writeObject(ObjectOutputStream stream) throws IOException
 * private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
 *
 *      在接口中定义的所有东西都自动是public的，因此如果writeObject()和readObject()必须是private的，那么它们不会是接口的一部分。因为我们必须
 * 要完全遵循其方法特征签名，所以其效果就和实现了接口一样。
 *      在调用ObjectOutputStream.writeObject()时，会检索所传递的Serializable对象，看看是否实现了它自己的writeObject().如果是这样，就跳过
 * 正常的序列化过程并调用它的writeObject().readObject()的情形于此相同。
 *      还有另外一个技巧。在你的writeObject()时，可以调用defaultWriteObject()来选择执行默认的writeObject().类似地，在readObject()内部，我们
 * 可以调用defaultReadObject()
 */

//Externalizable的替代方法
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String aa,String bb){
        a="Not Transient: "+aa;
        b="Transient: "+bb;
    }

    public String toString(){
        return a+"\n"+b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b= (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc=new SerialCtl("Test1","Test2");
        System.out.println("Before:\n"+sc);
        ByteArrayOutputStream buf=new ByteArrayOutputStream();
        ObjectOutputStream o=new ObjectOutputStream(buf);
        o.writeObject(sc);

        //Now get it back
        ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2= (SerialCtl) in.readObject();
        System.out.println("After:\n"+sc2);
    }
}
