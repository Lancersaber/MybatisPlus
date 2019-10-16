package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String args[]){
//        int [] arr={101,34,119,1};
//        insertSort(arr);
        int maxSize=80000;
        int []array=new int[maxSize];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*800000);//生成0~800000之间的数
        }

        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date);
        System.out.println("排序前的时间是"+date1Str);

        insertSort(array);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是"+date2Str);
    }

    /**
     * 插入排序（英语：Insertion Sort）是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到 {\displaystyle O(1)} {\displaystyle O(1)}的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param arr
     */
    public static void insertSort(int[] arr){
        /*
        //使用逐步推导的方式来讲解
        //第一轮{101,34,119,1};==> {34,101,119,1}

        //定义待插入的数据
        int insertVal=arr[1];
        int insertIndex=1-1;//即arr[1]的前面的数的下标

        //给insertVal找到插入的位置
        //说明
        //1、insertIndex>=0保证在给insertVal找插入位置时，不越界
        //2、insertVal<arr[insertIndex]说明待插入的数还没有找到该插入的位置
        //3、就需要将arr[insertIndex]后移
        while (insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];//重点语句
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，该位置为insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));

        //第二轮
        //定义待插入的数据
        insertVal=arr[2];
        insertIndex=2-1;//即arr[1]的前面的数的下标

        //给insertVal找到插入的位置
        //说明
        //1、insertIndex>=0保证在给insertVal找插入位置时，不越界
        //2、insertVal<arr[insertIndex]说明待插入的数还没有找到该插入的位置
        //3、就需要将arr[insertIndex]后移
        while (insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];//重点语句
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，该位置为insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));

        //第三轮
        //定义待插入的数据
        insertVal=arr[3];
        insertIndex=3-1;//即arr[1]的前面的数的下标

        //给insertVal找到插入的位置
        //说明
        //1、insertIndex>=0保证在给insertVal找插入位置时，不越界
        //2、insertVal<arr[insertIndex]说明待插入的数还没有找到该插入的位置
        //3、就需要将arr[insertIndex]后移
        while (insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];//重点语句
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，该位置为insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));
        */

        //使用for循环来把代码简化
        for(int i=1;i<arr.length;i++){
            int insertVal=arr[i];
            int insertIndex=i-1;
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];//重点语句
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，该位置为insertIndex+1
            arr[insertIndex+1]=insertVal;

//            System.out.println("第"+i+"轮");
//            System.out.println(Arrays.toString(arr));
        }
    }
}

