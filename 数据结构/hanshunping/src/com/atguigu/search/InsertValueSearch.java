package com.atguigu.search;

import java.util.Arrays;

//插入查找
//和二分查找类似，只是mid值不一样
public class InsertValueSearch {

    public static void main(String args[]){
        int[] arr=new int[100];
        for (int i=0;i<100;i++){
            arr[i]=i+1;
        }
//        System.out.println(Arrays.toString(arr));
        int i = insertValueSearch(arr, 0, arr.length - 1, 78);
        System.out.println(i);
    }

    //编写插值查找算法(要求数组是有序的)
    /**
     *
     * @param arr   数组
     * @param left  左边索引
     * @param right 右边索引
     * @param findVal  待查找的值
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        //注意：findVal<arr[0]||findVal>arr[arr.length-1] 必须需要
        //否则我们得到的mid可能越界
        System.out.println("查找次数~~");
        if(left>right|| findVal<arr[0]||findVal>arr[arr.length-1]){//需要好好研究一下
            return -1;
        }
        //求出mid
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(findVal>midVal){ //向mid右边递归
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归进行查找
            return insertValueSearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
}
