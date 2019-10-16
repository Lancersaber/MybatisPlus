package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//冒泡排序

/**
 * 冒泡排序小结：
 * 1、一共进行数组的大小-1次大的循环
 * 2、每一趟排序的次数都在逐渐减少
 */


public class BubbleSort {

    public static void main(String args[]){
//        int arr[]={3,9,-1,10,20};
//
//
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));

        //测试一下冒泡排序的速度O(n^2),给80000个数据，测试
        //创建要给80000个随机的数组
        int maxSize=80000;
        int []array=new int[maxSize];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*800000);//生成0~800000之间的数
        }

        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date);
        System.out.println("排序前的时间是"+date1Str);

        bubbleSort(array);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是"+date2Str);

    }

    //将前面的冒泡排序算法，封装成一个函数
    public static void bubbleSort(int[] arr){
        //冒泡排序的时间复杂度O(n^2)
        boolean flag=false;//表示是否进行过交换
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if(!flag){ //在一趟排序中，一次都没有交换过
                break;
            }else {
                flag=false; //重置flag!!! ,进行下次判断
            }
        }
    }

    public static void showProcess(int atrr[]){
        int temp=0;
        //为了容易理解，我们把冒泡排序的演变过程展示一下

        //第一趟排序，就是将最大的数排在最后
        /*for(int j=0;j<arr.length-1-0;j++){
            //如果前面的数比后面的数大，则交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }



        //第二趟排序，就是将第二大的数排在倒数第二位
        for(int j=0;j<arr.length-1-1;j++){
            //如果前面的数比后面的数大，则交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        for(int j=0;j<arr.length-1-2;j++){
            //如果前面的数比后面的数大，则交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        for(int j=0;j<arr.length-1-3;j++){
            //如果前面的数比后面的数大，则交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        */
    }
}
