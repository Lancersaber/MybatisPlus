package 第15章泛型.anonymousInnerClass;

import 第15章泛型.generator.Generator;
import 第15章泛型.generator.generic_generator.Generators;

import java.util.*;

/**
 * anonymous : 匿名
 * 泛型还可以应用于内部类以及匿名内部类。
 * 下面的示例使用匿名内部类实现了Generator接口
 */
public class BankTeller {
    public static void server(Teller t,Customer c){
        System.out.println(t+" serves "+c);
    }

    public static void main(String[] args){
        Random rand=new Random(47);
        Queue<Customer> line=new LinkedList<>();
        Generators.fill(line,Customer.generator(),15);
        List<Teller> tellers=new ArrayList<>();
        Generators.fill(tellers,Teller.generator(),4);
        for (Customer c:line){
            server(tellers.get(rand.nextInt(tellers.size())),c);
        }
    }
}

/**
 * Customer和Teller类都只有private的构造器，这强制你必须使用Generator对象
 */
class Customer{
    private static long counter=1;
    private final long id=counter++;
    private Customer(){

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }

    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}


class Teller{
    private static long counter=1;
    private final long id=counter++;
    private Teller(){}
    public String toString(){
        return "Teller "+id;
    }

    public static Generator<Teller> generator(){
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }

}
