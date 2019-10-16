package com.atguigu.search;

import java.util.ArrayList;

/**
 * 二分查找的思路分析
 * 1、首先确定该数组的中间的下标
 * mid=(left+right)/2;
 * 2、然后让需要查找的数findVal和arr[mid]比较
 * 2.1 findVal>arr[mid]说明在要查找的数在mid右边，因此需要递归地向右查找
 * 2.2 findVal<arr[mid],说明你要查找的数在mid的左边，因此需要递归地向左查找
 * 2.3 findVal==arr[mid],就返回
 *
 * 什么时候结束递归
 * 1）找到就结束递归
 * 2）递归完整个数组，仍然没有找到findVal，也需要结束递归，当left>right就需要退出
 */
public class BinarySearch {

    public static void main(String args[]){
//        int arr[]={1,8,10,89,1000,1000,1234};
//        ArrayList<Integer> i = binarySearch2(arr, 0, arr.length - 1, 1000);
//        if(i!=null){
//            System.out.println("索引为"+i);
//        }
        int[] arr=new int[100];
        for (int i=0;i<100;i++){
            arr[i]=i+1;
        }
        int i = binarySearch(arr, 0, arr.length - 1, 78);
        System.out.println(i);
    }

    //二分查找算法

    /**
     *
     * @param arr   数组
     * @param left  左边索引
     * @param right 右边索引
     * @param findVal   要查找的值
     * @return  如果找到就返回下标，如果没有就返回-1
     */
    //注意：二分查找的数组必须是有序数组
    public static int binarySearch(int[] arr,int left,int right,int findVal){

        System.out.println("查找次数~~");
        //当left>right时，说明递归整个数组，但是没有找到
        if(left>right){
            return -1;
        }

        int mid=(left+right)/2;
        int midVal=arr[mid];

        if(findVal > midVal){ //向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal < midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }

    /**
     * 在一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，
     *
     * 思路分析
     * 1、在找到mid索引值时，不要马上返回
     * 2、向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合中
     * 3、向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合中
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){

        //当left>right时，说明递归整个数组，但是没有找到
        if(left>right){
            return null;
        }

        int mid=(left+right)/2;
        int midVal=arr[mid];

        if(findVal > midVal){ //向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else if(findVal < midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else {
            ArrayList<Integer> resIndexlist=new ArrayList<>();
            //2、向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合中
            int temp=mid-1;
            while (true){
                if(temp<0||arr[temp]!=findVal){//退出
                    break;
                }
                //否则，将temp放入resIndexList
                resIndexlist.add(temp);
                temp-=1;//temp左移
            }
            resIndexlist.add(mid);

            //3、向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合中
            temp=mid+1;
            while (true){
                if(temp>arr.length-1||arr[temp]!=findVal){//退出
                    break;
                }
                //否则，将temp放入resIndexList
                resIndexlist.add(temp);
                temp+=1;//temp右移
            }
            return resIndexlist;
        }
    }
}
