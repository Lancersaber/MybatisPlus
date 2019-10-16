package 第11章持有对象.printingcontainers;

import java.util.*;

public class PrintingContainers {

    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }

    public static void main(String[] args){
        System.out.println("ArrayList==>"+fill(new ArrayList<>()));
        System.out.println("LinkedList==>"+fill(new LinkedList<>()));
        System.out.println("HashSet==>"+fill(new HashSet<>()));
        System.out.println("TreeSet==>"+fill(new TreeSet<>()));
        System.out.println("LinkedHashSet==>"+fill(new LinkedHashSet<>()));
        System.out.println("HashMap==>"+fill(new HashMap<>()));
        System.out.println("TreeMap==>"+fill(new TreeMap<>()));
        System.out.println("LinkedHashMap==>"+fill(new LinkedHashMap<>()));
    }
    /**
     * java容器库中有两种类型
     * 一、Collection(在每个槽中只能保存一个元素)
     * 1、List:
     * 2、Set：元素不能重复
     *      2.1、HashSet:使用的是相当复杂的方式来存储元素，这种技术是最快的获取元素方式，因此这种存储顺序看起来无实际意义
     *      2.2、TreeSet:如果存储顺序很重要，那么可以使用TreeSet，它按照结果的升序保存对象
     *      2.3、LinkedHashSet：按照被添加的顺序保存对象
     * 3、Queue：只允许在容器的一端插入对象，先进先出
     *
     * 二、Map(在每个槽内保存了两个对象，即键和与之相关联的值)
     * 1.1 HashMap：HashMap和HashSet一样，也提供了最快的查找技术，也没有按照任何明显的顺序来保存其元素
     * 1.2、TreeMap按照比较的结果的升序保存键
     * 1.3、LinkedHashMap则按照插入顺序保存键，同时还保留了HashMap的查询速度
     */
}
