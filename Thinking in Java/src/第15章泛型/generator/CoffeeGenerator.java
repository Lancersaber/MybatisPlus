package 第15章泛型.generator;

import 第15章泛型.generator.testClass.*;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {
    private Class[] types={Latte.class, Mocha.class, Cappuccino.class, Americano.class,Breve.class};
    private static Random random=new Random(47);

    public CoffeeGenerator(){

    }

    //For iteration
    private int size=0;
    public CoffeeGenerator(int size){
        this.size=size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        }catch (Exception o){
            throw new RuntimeException();
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{

        int count=size;
        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }

    /**
     * Iterable接口和Iterator接口的区别
     *      public interface Iterable<T> {
     *          Iterator<T> iterator();
     *        }
     *
     *    public interface Iterator<E> {
     *      boolean hasNext();
     *
     *      E next();
     *
     *      void remove();
     *    }
     *
     *    Iterator是迭代器类，而Iterable是为了只要实现该接口就可以使用foreach，进行迭代。
     *    Iterable中封装了Iterator接口，只要实现了Iterable接口的类，就可以使用Iterator迭代器了。
     */

    public static void main(String[] args){
        CoffeeGenerator gen=new CoffeeGenerator();
        for (int i=0;i<5;i++){
            System.out.println(gen.next());
        }
        System.out.println("*************");
        for (Coffee c:new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }
}
