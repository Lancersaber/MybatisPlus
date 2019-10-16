package com.atguigu.sort;

import java.util.Arrays;

public class MergetSort {

    public static void main(String args[]){
        int arr[]={8,4,5,7,1,3,6,2};
        int[] array={9,8,7,6};
        int[] temp=new int[arr.length];//归并排序需要一个额外的空间
        mergeSort(array,0,array.length-1,temp);
        System.out.println(Arrays.toString(array));

    }
    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid=(left+right)/2; //中间索引
            //向左递归进行分离
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
//            System.out.println(Arrays.toString(arr));
            //到合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并的方法
    /**
     *
     * @param arr:待排序的数组
     * @param left：左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int leftPartIndex = left;//初始化i，左边有序序列的初始索引
        int rightPartIndex=mid+1;//初始化j，表示右边有序序列的初始索引
        int tempIndex=0;//指向temp数组的索引

        //先把左右两边(有序)的数据按规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (leftPartIndex<=mid&&rightPartIndex<=right){
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素拷贝到temp数组中
            if(arr[leftPartIndex]<=arr[rightPartIndex]){
                temp[tempIndex++]=arr[leftPartIndex++];
            }else {//反之将右边的有序序列的当前元素，填充到temp数组
                temp[tempIndex++]=arr[rightPartIndex++];
            }
        }

        //把有剩余数据的一边的数据依次全部填充到temp
        while (leftPartIndex<=mid){//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[tempIndex++]=arr[leftPartIndex++];
        }

        while (rightPartIndex<=right){
            temp[tempIndex++]=arr[rightPartIndex++];
        }

        //将temp数组的元素拷贝到arr
        //注意：不是每次都拷贝所有
        tempIndex=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft++]=temp[tempIndex++];
        }
    }
}
