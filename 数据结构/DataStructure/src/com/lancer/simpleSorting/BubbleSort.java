package com.lancer.simpleSorting;

//冒泡排序
public class BubbleSort extends BaseClass{

    public BubbleSort(int max) {
        super(max);
    }

    //------------------------------
    public void bubbleSort(){
        int out,in;

        /**
         * 何为冒泡排序？（或者说冒泡排序的主要思想是什么？）
         * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。
         * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
         *
         * 冒泡排序在进行第一趟排序之后，进行了N-1次比较，进行了最少0次，最多N-1交换。数据最末端的那个数据项就此排定，不再进行移动。
         * 同理，在进行第二趟排序之后，进行了N-2次比较，进行了最少0次，最多N-2交换。数据次末端的那个数据项就此排定，不再进行移动。
         * 所以在最坏的情况下，冒泡排序必须进行第N-1趟排序(相当于外层循环)，需要(N-1)+(N-2)+(N-3)+...+2 次比较(这相当于内循环)
         *
         * 故下面的程序写得相当精炼，也相当正确
         */


        for(out=nElems-1;out>1;out--){  //outer loop(backward)
            for (in=0;in<out;in++)      //inner loop (forward)
                if(a[in]>a[in+1])       //out of order
                    swap(in,in+1);  //swap them
        }
    }


    public static void main(String args[]){
        BubbleSort bubbleSort=new BubbleSort(10);
        bubbleSort.initArray();
        bubbleSort.display();
        bubbleSort.bubbleSort();
        bubbleSort.display();
    }
}
