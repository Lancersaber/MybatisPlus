package com.lancer.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个栈的数据
 * 比如第一个是1，2，3，4，5
 * 它可能是以4，5，3，2，1的顺序进行输出，但是它不可能以4，3，5，2，1的顺序进行输出，
 * 写一个程序进行判断
 */
public class judgeIsStack {

    public static void main(String[] args){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2=new ArrayList<>();
        list2.add(4);
        list2.add(3);
        list2.add(5);
        list2.add(2);
        list2.add(1);

        boolean stack = isStack(list1, list2);
        System.out.println(stack);
    }

    public static boolean isStack(List A, List B){
        int[] index=new int[A.size()];
        for (int i=0;i<A.size();i++){
            index[i]=A.indexOf(B.get(i));
        }
        System.out.println(Arrays.toString(index));
        int max=0,maxIndex=0;
        for (int i=0;i<index.length-1;i++){
            if (index[i]<index[i+1]){
                max=index[i+1];
                maxIndex=i+1;
            }
        }

        System.out.println(max+" "+maxIndex);

        for (int i=0;i<maxIndex-1;i++){
            if (index[i]>index[i+1]){
                return false;
            }
        }

        for (int i=maxIndex+1;i<A.size()-1;i++){
            if (index[i]<index[i+1]){
                return false;
            }
        }

        return true;
    }
}
