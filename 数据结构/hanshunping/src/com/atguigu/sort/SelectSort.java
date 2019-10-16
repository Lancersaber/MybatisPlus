package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {

    public static void main(String args[]){
//        int[] arr={101,34,119,1};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);

        int maxSize=80000;
        int []array=new int[maxSize];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*800000);//生成0~800000之间的数
        }

        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date);
        System.out.println("排序前的时间是"+date1Str);

        selectSort(array);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是"+date2Str);
    }

    /**
     * 选择排序（Selection sort）是一种简单直观的排序算法。
     * 它的工作原理如下。
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
     *
     * 选择排序的主要优点与数据移动有关。
     * 如果某个元素位于正确的最终位置上，则它不会被移动。
     * 选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，
     * 因此对 {\displaystyle n} n个元素的表进行排序总共进行至多 {\displaystyle n-1} {\displaystyle n-1}次交换。
     * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
     */

    /**
     * 选择排序小结：
     * 1、选择排序一共有数组大小-1 轮排序
     * 2、每一轮排序，又是一个循环，循环的规则(思路)
     * 2.1先假定当前这个数是最小数
     * 2.2然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
     * 2.3当遍历到数组的最后时，就得到本轮的最小数和下标
     * 2.4交换
     */
    public static void selectSort(int[] arr){

        //使用逐步推导的方式来讲解选择排序
        //第一步
        //原始数组：101，34，119，1
        //第一轮排序：1，34，119，101
        //算法先简单==》再复杂，就是可以把一个复杂的算法拆分成简单的问题

        //第一轮
        /*int minIndex=0;
        int min=arr[0];
        for(int j=0+1;j<arr.length;j++){
            if(min>arr[j]){//说明假定的最小值不是最小
                //重置最小值和索引
                min=arr[j];
                minIndex=j;
            }
        }
        //将最小值与arr[0]交换
        if (minIndex!=0){
            arr[minIndex]=arr[0];
            arr[0]=min;
        }
        System.out.println("第一轮后"+ Arrays.toString(arr));

        //第二轮
        minIndex=1;
        min=arr[minIndex];
        for(int j=1+1;j<arr.length;j++){
            if(min>arr[j]){//说明假定的最小值不是最小
                //重置最小值和索引
                min=arr[j];
                minIndex=j;
            }
        }
        //将最小值与arr[0]交换
        if(minIndex!=1){
            arr[minIndex]=arr[1];
            arr[1]=min;
        }
        System.out.println("第二轮后"+ Arrays.toString(arr));

        //第三轮
        minIndex=2;
        min=arr[minIndex];
        for(int j=2+1;j<arr.length;j++){
            if(min>arr[j]){//说明假定的最小值不是最小
                //重置最小值和索引
                min=arr[j];
                minIndex=j;
            }
        }
        //将最小值与arr[0]交换
        if(minIndex!=2){
            arr[minIndex]=arr[2];
            arr[2]=min;
        }
        System.out.println("第三轮后"+ Arrays.toString(arr));*/
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
//            System.out.println("第"+(i+1)+"轮");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
