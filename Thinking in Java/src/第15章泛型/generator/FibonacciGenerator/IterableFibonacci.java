package 第15章泛型.generator.FibonacciGenerator;

import java.util.Iterator;

/**
 *      如果还想进一步，编写一个实现了Iterable的Fibonacci生成器，我们的一个选择是重写这个类，令其实现Iterable接口。
 * 不过，我们并不能总是拥有源代码的控制权，并且，除非必须这么做，否则，我们也不愿意重写这个类。
 * 另外一个选择是创建一个适配器来实现所需的接口。
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count){
        n=count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    /**
     *  如果要在循环语句中使用IterableFibonacci，必须向IterableFibonacci的构造器提供一个边界值，然后hasNext()方法才知道何时应该返回false
     */
    public static void main(String[] args){
        for (int i: new IterableFibonacci(18)){
            System.out.print(i+" ");
        }
    }
}
