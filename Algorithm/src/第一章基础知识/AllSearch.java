package 第一章基础知识;

import java.util.Arrays;

public class AllSearch {

    public static void main(String[] args){
        int a[]={21,12,1,0,-90,100,22};
        AllSorts.quick(a);
        System.out.println(Arrays.toString(a));
        int i = binarySearch(a, 100);
        System.out.println(i);
    }

    //二分查找（前提：查找的数组必须是排序好的）
    // 第一种：使用while循环来进行查找
    public static int binarySearch(int a[],int key){
        int lo=0;
        int hi=a.length;
        int mid=(lo+hi)/2;
        while (lo<=hi){ //这里带不带等号???
            if (a[mid]>key){    //中间值大于key,说明key值只能在左边
                lo=mid-1;
            }else if (a[mid]<key){    //中间值小于key,说明key值只能在左边
                lo=mid+1;
            }else {
                return mid;
            }
            mid=(lo+hi)/2;
        }
        return -1;
    }

    //第二种 使用递归的方式进行二分查找
    public static int binarySearch(int[] a,int key,int lo,int hi){
        if (lo>hi){ //这里不带等号
            return lo;  //为什么return lo
        }

        int mid=(lo+hi)/2;
        if (a[mid]>key)
            return binarySearch(a,key,lo,mid-1);
        else if (a[mid]<key)
            return binarySearch(a,key,mid+1,hi);
        else return mid;
    }

    //将一个数组打乱
    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
}
