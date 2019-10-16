package com.lancer.advanceSorting;

import com.lancer.simpleSorting.BaseClass;

public class ShellSort extends BaseClass {
    public ShellSort(int max) {
        super(max);
    }

    /**
     * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。
     * 这样可以让一个元素可以一次性地朝最终位置前进一大步。
     * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
     *
     * 希尔排序是基于插入排序的，下面是插入排序带来的问题。假设一个很小的数据项在很靠近右端的位置上，这里本来应该是值比较大的数据项原来所在的位置。
     * 把这个小数据项移动到左边的位置上，所有的中间数据项都必须向右移动一位。如果能以某种方式不必一个一个移动所有的中间项，就能把较小的数据项移动到
     * 左边，那么这个算法的执行效率就会有很大的改进，
     */

    public void shellSort(){
        int inner,outer;
        long temp;

        int h=1;       //find initial value of h,看看最开始是以几为间隔取值
        while (h<nElems/3)
            h=h*3+1;    //(1,4,13........)

        while (h>0){    //减少h,直到h=1

            for(outer=h;outer<nElems;outer++){
                temp=a[outer];
                inner=outer;

                while (inner>h-1&&a[inner-h]>=temp){//每次实际上就两个值进行比较，因为前面的值已经排好序了
                    a[inner]=a[inner-h];
                    inner-=h;
                }
                a[inner]=temp;
            }//end for
            h=(h-1)/3;  //减少h
        }
    }

    public static void main(String args[]){
        ShellSort shellSort=new ShellSort(10);
        shellSort.initArray();
        shellSort.display();
        shellSort.shellSort();
        shellSort.display();
    }
}
