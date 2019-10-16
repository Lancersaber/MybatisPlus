package 第15章泛型.tuple;

/**
 * 简化元祖的使用
 */
public class Tuple {
    public static <A,B> TwoTuple<A,B> tuple(A a,B b){
        return new TwoTuple<>(a,b);
    }

    public static <A,B,C> ThreeTuple<A,B,C> tuple(A a,B b,C c){
        return new ThreeTuple<>(a,b,c);
    }

//    public static <A,B,C,D> FourTuple<A,B,C,D> tuple(A a,B b,C c,D d){
//        return new FourTuple
//    }
}
