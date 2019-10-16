package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String args[]){
        int arr[]={8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //使用逐步推导的方式来编写希尔排序
    //1、希尔排序时，对有序序列在插入时采用交换法，并测试排序速度
    //2、希尔排序时，对有序序列在插入时采用移动法，并测试排序速度
    public static void shellSort(int[] arr){


        //第一轮希尔排序
        //因为第一轮排序，是将10个数据分成了5组
        int temp=0;
        for(int i=5;i<arr.length;i++){
            //遍历各组中所有的元素(共5组，每组有两个元素，步长为5)
            for(int j=i-5;j>=0;j-=5){
                //如果当前元素大于加上步长后的那个元素，说明交换
                System.out.println("["+arr[j]+","+arr[j+5]+"]");
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println("希尔排序第一轮");
        System.out.println(Arrays.toString(arr));

        //第2轮希尔排序
        //因为第2轮排序，是将10个数据分成了5/2组
        System.out.println("希尔排序第二轮");
        for(int i=2;i<arr.length;i++){
            //遍历各组中所有的元素(共5组，每组有两个元素，步长为5)
            for(int j=i-2;j>=0;j-=2){
                System.out.println("["+arr[j]+","+arr[j+2]+"]");
                //如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println("希尔排序第2轮");
        System.out.println(Arrays.toString(arr));

        //第3轮希尔排序
        //因为第3轮排序，是将10个数据分成了5/2/2组
        for(int i=1;i<arr.length;i++){
            //遍历各组中所有的元素(共5组，每组有两个元素，步长为5)
            for(int j=i-1;j>=0;j-=1){
                //如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("希尔排序第2轮");
        System.out.println(Arrays.toString(arr));

       /* //根据前面的逐步分析，使用循环处理
        int temp=0;
        int time=1;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                //遍历各组中所有的元素(共gap组，每组有两个元素，步长为gap)
                for(int j=i-gap;j>=0;j-=gap){
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j]>arr[j+1]){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
//            System.out.println("第"+(time++)+"轮");
//            System.out.println(Arrays.toString(arr));
        }*/
    }

    //对交换式的希尔排序进行优化==>移位法
    public static void shellSort2(int[] arr){

        //增量gap，并逐步的缩小增量
        for (int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while循环后，就给temp找到插入的位置
                    arr[j]=temp;
                }
            }
        }
    }
}
