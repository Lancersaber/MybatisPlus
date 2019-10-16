package 第11章持有对象.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器存在的缘由：
 *     任何容器类都必须有某种方式可以插入元素并将它们再次取回。毕竟，持有事物是容器最基本的工作。
 *     如果从更高层的角度思考，会发现这里有个缺点：要使用容器，必须对容器的确切类型编码。初看起来并没什么不好，但是考虑下面情况
 * 如果原来是对List编码的，但是后来发现如果能够把相同的代码应用于Set，将会显得非常方便。此时应该怎么做？重新再编写一段代码？它们只是
 * 使用容器，不知道或者说不关心容器的类型，迭代器正是为了解决这样的问题的。
 */
//总结起来：迭代器统一了对容器的访问方式(仅限于Collection)
public class SimpleIteration {

    public static void main(String[] args){
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> iterator=list.iterator();
        //有了Iterator就不必为容器中元素的数量操心了，那是由hasNext()和next()关心的事情
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            /**
             * .remove（）将会删除上次调用next（）时返回的元素，也就是说先调用next（）方法，
             * 再调用remove方法才会删除元素。next（）和romove方法具有依赖性，
             * 必须先用next，再使用romove。如果先用remove方法会出现IllegalStateException异常。
             */
            iterator.remove();
        }
        System.out.println("list是否为空："+list.isEmpty());
    }
}
