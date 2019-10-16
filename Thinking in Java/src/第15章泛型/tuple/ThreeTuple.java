package 第15章泛型.tuple;

import java.util.HashMap;
import java.util.Map;

//我们可以利用继承机制实现更长的元组。
public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
    public final C third;
    public ThreeTuple(A a, B b,C c) {
        super(a, b);
        third=c;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args){
        HashMap<Integer, StringBuilder> map=new HashMap<>();
        StringBuilder builder=new StringBuilder();
        for (Integer i=0;i<10;i++){
            builder.append(i.toString());
            map.put(i,builder);
        }
        for (Map.Entry<Integer,StringBuilder> entry: map.entrySet()){
            System.out.println(entry.getKey()+"==>"+entry.getValue());
        }
    }
}
