package 第11章持有对象.Foreach_Iterator;

import java.util.Iterator;

/**
 * foreach语法主要用于数组，但是它也可以用于任何Collection对象。
 *      之所以能够工作，是因为Java SE5 引入了被称为Iterable的接口，该接口包含了一个能够产生Iterator的iterator()方法，并且Iterable接口被
 * foreach用来在序列中移动。因此如果你创建了任何实现Iterable的类，都可以将它用在foreach语句中。
 */

public class IterableClass implements Iterable<String> {

    //经过输出结果显示确实是这样
    public static void main(String[] args){
        for (String s:new IterableClass()){
            System.out.print(s+" ");
        }
    }

    protected String[] words=("And that is how we know the Earth to be banana-shaped.").split(" ");

    public Iterator<String> iterator(){
        return new Iterator<String>() {

            private int index=0;

            @Override
            public boolean hasNext() {
                return index<words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }
}
