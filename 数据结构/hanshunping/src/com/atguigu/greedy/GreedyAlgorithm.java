package com.atguigu.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *  贪心算法介绍
 *  1、贪婪算法是指对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而希望能够导致结果是最好或者最优的解法
 *  2、贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果。
 */
public class GreedyAlgorithm {

    public static void main(String[] args){
        //创建广播电台，放入到Map中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts中
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet4.add("杭州");
        hashSet4.add("大连");

        //加入到Map
        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);

        //allAreas存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("大连");

        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义一个maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的key
        //如果maxKey不为null，则会加入到selects
        String maxKey=null;
        while (allAreas.size()!=0){     //如果allAreas不为0，则表示还没有覆盖到所有的地区

            //遍历broadcasts，取出对应key
            for (String key:broadcasts.keySet()){
                //当前key能覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet 和 allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);

                //如果当前这个集合包含的未覆盖地区的数量，比mapKey指向的集合地区还多，就需要重置maxKey
                if (tempSet.size()>0 && ((maxKey==null)||tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey=key;
                }
            }
            //maxKey!=null,就应该将maxKey 加入selects中
            if (maxKey !=null){
                selects.add(maxKey);
            }
        }
    }
}
