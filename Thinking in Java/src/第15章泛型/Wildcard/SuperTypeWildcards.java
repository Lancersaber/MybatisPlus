package 第15章泛型.Wildcard;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards {

    //不能对泛型参数给出一个超类型边界，即不能声明<T super MyClass>
    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit()); Error
    }

    public static void main(String[] args){
//        writeTo(new ArrayList<Jonathan>());   Compiler error
    }
}
