package com.lancer.simpleSorting;

public class InsertionSort extends BaseClass{
    public InsertionSort(int max) {
        super(max);
    }

    /**
     * 插入排序（英语：Insertion Sort）是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，
     * 在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，
     * 通常采用in-place排序（即只需用到 {\displaystyle O(1)} {\displaystyle O(1)}的额外空间的排序），因而在从后向前扫描过程中，
     * 需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     */

    public void insertionSort(){
        int in,out;

        for(out=1;out<nElems;out++){    //out is dividing line
            long temp=a[out];   //remove marked item
            in=out;             //内层循环最多循环out-1次
            while (in>0 && a[in-1]>=temp){  //如果已排好序的部分有值比目标数大，就向右移动
                a[in]=a[in-1];
                in--;
            }
            a[in]=temp; //插入temp，也就是a[out]
        }
    }

    public static void main(String args[]){
        BaseClass baseClass=new InsertionSort(10);
        baseClass.initArray();
        baseClass.display();
        ((InsertionSort) baseClass).insertionSort();
        baseClass.display();
    }
}
