package com.lancer.simpleSorting;

public class SelectionSort extends BaseClass{
    public SelectionSort(int max) {
        super(max);
    }

    /**
     * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。
     * 选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，
     * 因此对 {\displaystyle n} n个元素的表进行排序总共进行至多 {\displaystyle n-1} {\displaystyle n-1}次交换。
     * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
     */

    public void selectionSort(){
        for(int out=0;out<nElems;out++){
            for(int in=out+1;in<nElems;in++){
                /**
                 * 如果if判断中为>,那么表示保证a[out]永远是最大的值
                 * 如果if判断中为<,表示保证a[out]永远是最小的
                 */
                if(a[in]>a[out]){
                    swap(in,out);
                }
            }
        }
    }

    public static void main(String args[]){
        SelectionSort selectionSort=new SelectionSort(10);
        selectionSort.initArray();
        selectionSort.display();
        selectionSort.selectionSort();
        selectionSort.display();
    }
}
