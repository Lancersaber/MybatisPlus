package 第11章持有对象.Foreach_Iterator;

import java.util.Arrays;

/**
 *      foreach语句可以用于数组或其他任何Iterable，但是这并不意味着数组肯定也是一个Iterable，而任何自动包装也不会自动发生
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib){
        for (T t:ib){
            System.out.print(t+" ");
        }
    }

    public static void main(String[] args){
        test(Arrays.asList(1,2,3));
        String[] strings={"A","B","C"};
        //An array works in foreach , but it's not iterable
        //! test(strings)
        //You must explicitly convert it to an Iterable
        test(Arrays.asList(strings));

        /**
         * 上面尝试把数组当作一个Iterable参数传递会导致失败。这说明不存在任何从数组到Iterable的自动转换，必须手动执行这种转换。
         */
    }
}
