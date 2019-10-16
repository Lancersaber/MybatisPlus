package 第15章泛型.generator.generic_generator;

import 第15章泛型.generator.CoffeeGenerator;
import 第15章泛型.generator.FibonacciGenerator.Fibonacci;
import 第15章泛型.generator.Generator;
import 第15章泛型.generator.testClass.Coffee;

import java.util.*;

public class Generators {

    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen,int n){
        for (int i=0;i<n;i++){
            coll.add(gen.next());
        }
        if (coll instanceof Set){
            System.out.println("coll is a Set");
        }
        System.out.println(coll.getClass().getSimpleName());
        return coll;
    }

    public static void main(String[] args){
        List<Coffee> list=new ArrayList<>();
        Collection<Coffee> coffees=fill(list,new CoffeeGenerator(),4);
        for (Coffee c:coffees){
            System.out.println(c);
        }

        Collection<Integer> fnumbers=fill(new ArrayList<Integer>(),new Fibonacci(),12);
        for (int i:fnumbers){
            System.out.print(i+" ");
        }
    }
}
