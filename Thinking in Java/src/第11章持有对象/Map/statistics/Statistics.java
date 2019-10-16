package 第11章持有对象.Map.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {

    public static void main(String[] args){
        Random rand=new Random(47);
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<10000;i++){
            //Produce a number between 0 and 20
            int r=rand.nextInt(20);
            Integer freq= map.get(r);
            map.put(r,freq==null?1:freq+1);
        }
        System.out.println(map);
        //下面几种取出Map值的方法
        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (int key:map.keySet()){
            System.out.print(key+":"+map.get(key)+" ");
        }

        //第三种：推荐，尤其是容量大时</span>
        /**
         * 着重介绍一下该方法
         * Map是java中的接口，Map.Entry是Map的一个内部接口
         * Map提供了一些常用方法，如keySet()、entrySet()等方法。
         * keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
         * Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
         */
        System.out.println();
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }
    }
}
