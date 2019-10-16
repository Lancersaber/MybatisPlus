package 第二章Sort.BasicSort;

import 第一章基础知识.Utils;

import java.util.Arrays;

public class MyQuick3way extends Example {


    public static void sort(Comparable[] a,int lo,int hi){
        if (hi<=lo)
            return;
        int It=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
//        System.out.println("v = "+a[lo]);
//        System.out.println(Arrays.toString(a));
        System.out.println("进入循环");
        while (i<=gt){ //当i > gt 时退出循环
            int cmp=a[i].compareTo(v);
            if (cmp<0) exch(a,It++,i++);
            else if (cmp>0) exch(a,i,gt--);
            else i++;
//            System.out.println(Arrays.toString(a));
        }
//        System.out.println("a[gt] = "+a[gt]);
//        return;
        sort(a,lo,It-1);
        sort(a,gt+1,hi);
    }

    public static void main(String[] args){
        Integer[] array = Utils.createArray(10);
        Integer [] test={8,9,8,7,7,6,6,3,8,1};
        sort(test,0,test.length-1);
        System.out.println(Arrays.toString(test));
    }
}
