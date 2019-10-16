package 第11章持有对象.Foreach_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * P243页 适配器方法惯用法
 *  当你有一个接口并需要另一个接口时，编写适配器就可以解决问题
 */
public class AdapterMethodIdiom{
    public static void main(String[] args){
        ReversibleArrayList<String> ral=new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        //Grabs the ordinary iterator via iterator()
        for (String s:ral){
            System.out.print(s+" ");
        }
        System.out.println();
        //Hand it the Iterable of your choice
        for (String s:ral.reversed()){
            System.out.print(s+" ");
        }
    }
}


class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }

    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current=size()-1;
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}


