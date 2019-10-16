package 第二章Sort.BasicSort;

import java.util.Arrays;

public class MyHeap {

    public static void main(String[] args){
        MyHeap myHeap=new MyHeap();
        int size=10;
        Integer[] a=new Integer[size];
        for (int i=0;i<size;i++){
            a[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        MyHeap.sort(a);
        System.out.println(Arrays.toString(a));

    }

    private MyHeap(){

    }

    /**
     * 将pq数组从k 到 n 进行下沉
     * @param pq 带下沉的数组
     * @param k  从 第k 个位置开始
     * @param n  到 第n 个位置结束
     */
    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    public static void sort(Comparable[] pq) {
        int n = pq.length;
        //这个for循环怎么理解？？？
        //为什么要从 k=n/2 开始；因为这是
        for (int k = n/2; k >= 1; k--){
            System.out.println("pq["+k+"] = "+pq[k]);
            sink(pq, k, n);
        }
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
}
