package 第15章泛型.tuple;

/**
 *  仅用一次方法就能返回多个对象
 */
public class TwoTuple<A,B> {
    /**
     * 这里的两个对象都被置为public，是否违背了java编程的安全性原则？
     *  answer：并没有，客户端程序可以读取first和second对象，然后随心所欲地使用这两个对象。但是他们却无法将其他值赋值给
     *  first和second对象，因为final声明提供了保险。
     */
    public final A first;
    public final B second;

    public TwoTuple(A a,B b){
        first=a;
        second=b;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
