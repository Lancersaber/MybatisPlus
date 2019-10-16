package 第11章持有对象.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基本的
 */
public class ListFeatures {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=10;i++){
            list.add(i);
        }
        System.out.println(list);
        List<Integer> list1 = list.subList(1, 4);
        //list.subList(num1,num2);截取的总个数为num2-num1个，其中包含第num1个，不包含第num2个
        System.out.println(list1);
        //retainAll方法是一种有效的“交集”操作
        list.retainAll(list1);
        System.out.println(list);
//        Integer[] array=new Integer[10];
//        for (int i=1;i<=10;i++){
//            array[i]=i;
//        }
//        list.toArray(array);
//        System.out.println(Arrays.toString(array));
    }
}
