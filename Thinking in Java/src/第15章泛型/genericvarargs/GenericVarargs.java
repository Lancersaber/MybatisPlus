package 第15章泛型.genericvarargs;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {

    public static <T> List<T> makeList(T... args){
        /**
         * 可变参数的基本介绍
         *      有了可变参数，就再也不用显示地编写数组语法了，当你指定参数时，编译器实际上会为你去填充数组。
         * 你获取的仍是一个数组，这就是为什么可以使用foreach来迭代该数组的原因。
         */
        List<T> result=new ArrayList<>();
        for (T item:args){
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args){
        List<String> ls=makeList("A");
        System.out.println(ls);
        ls=makeList("A B C".split(" "));
        System.out.println(ls);
    }
}
