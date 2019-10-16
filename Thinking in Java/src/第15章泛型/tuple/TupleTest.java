package 第15章泛型.tuple;

public class TupleTest {
    static TwoTuple<String,Integer> f(){
        return new TwoTuple<>("hi",47);
    }

    static ThreeTuple<Amphibian,String,Integer> g(){
        return new ThreeTuple<>(new Amphibian(),"hi",47);
    }

    public static void main(String[] args){
        TwoTuple<String,Integer> ttsi=f();
        System.out.println(ttsi);
        System.out.println(g());
    }
}

class Amphibian{}
class Vehicle{}
