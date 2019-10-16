package 第13章String.infinite_recursion;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

    public String toString(){
        //如果你希望toString()方法打印出对象的内存地址，也许你会考虑使用this关键字
        return "InfiniteRecursion address: "+this+"\n";//wrong
//        return "InfiniteRecursion address: "+this+"\n"; //  true
    }

    public static void main(String[] args){
        List<InfiniteRecursion> v=new ArrayList<>();
        for (int i=0;i<10;i++){
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
    /**
     * 将Main函数运行后会得到一串非常长的异常。
     * 其实，当如下代码运行时
     * "InfiniteRecursion address: "+this+"\n";这里发生了自动类型转换，由 InfiniteRecursion 类型转换成String类型。因为编译器
     * 看到一个String对象后面跟着一个"+",而后面的对象不是String，于是编译器试着将this转换成为一个String。它怎么转换呢，正是通过调用this上的toString方法，于是
     * 就发生了递归调用。
     *
     * 如果真的想要打印出对象的内存地址，应该调用Object.toString()方法，所以。不应该使用this，而是应该调用super.toString()方法
     */
}
