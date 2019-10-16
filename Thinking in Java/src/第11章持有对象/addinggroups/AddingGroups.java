package 第11章持有对象.addinggroups;

import java.util.*;

public class AddingGroups {
    /**
     *  在java.util包中的Arrays和Collections类中有很多实用的方法，可以在一个Collection中添加一组元素。
     *  1、Arrays.asList()方法接收一个数组或是一个用逗号分隔的元素列表(使用可变参数)
     *  2、Collections.addAll()方法接收一个Collection对象，以及一个数组或是一个用逗号分隔的元素列表，将元素添加到Collection中
     */
    public static void main(String[] args){
        Collection<Integer> collection=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts={6,7,8,9,10};
        collection.addAll(Arrays.asList(6,7,8,9,10));

        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);
        System.out.println(collection);

        //Produces a list "backed by" an array      back by 依靠，通过
        List<Integer> list=Arrays.asList(16,17,18,19,20);
        list.set(1,99);//OK -- modify an element
        //Arrays.asList()生成的list底层表示是数组，因此不能 resize
//        list.add(21);
    }
}
