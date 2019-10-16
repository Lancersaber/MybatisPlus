package 第15章泛型.listOfGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 *  正如你在前面所见，不能创建泛型数组。一般的解决方法是在任何想要创建泛型数组的地方使用ArrayList
 */
public class ListOfGenerics<T> {

    private List<T> array=new ArrayList<>();
    public void add(T item){
        array.add(item);
    }

    public T get(int index){
        return array.get(index);
    }
}
//这里你将获得数组的行为，以及由泛型提供的编译期的类型安全
