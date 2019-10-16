package 第一章基础知识;

import java.util.Arrays;

public class MaxPQ1<Key extends Comparable<Key>>{

    public static void main(String[] args){

        MaxPQ1<Integer> pq1=new MaxPQ1<>(10);
//        Integer[] a=new Integer[10];
        for (int i=0;i<10;i++){
//            a[i]=(int)(Math.random()*100);
            pq1.insert((int)(Math.random()*100));
        }
        pq1.show();
    }

    private Key[] pq; //key数组
    private int N; //数组中元素的个数


    //构造函数
    public MaxPQ1(int capacity){
        pq=(Key[])new Comparable[capacity+1]; //这里加一是因为 数组第一个位置也就是pq[0]不存放数据
    }

    public boolean isEmpty(){
        return N==0;
    }

    //扩容函数
    private void resize(int capacity){
        assert capacity>N;
        Key[] temp=(Key[])new Comparable[capacity];
        for (int i=1;i<=N;i++){
            temp[i]=pq[i];
        }
        pq=temp;
    }

    public void insert(Key key){
        //如果数组已经满了，就进行扩容
        if (N==pq.length-1)
            resize(2*N);

        //注意这里是++N，因为刚开始N=0，++N后等于1 ，正好跳过 pq[0]
        pq[++N]=key;
        swim(N);
        assert isMaxHeap();
    }

    //当子结点的值大于父结点时，上浮
    public void swim(int k){ //这里的参数是目标数的位置，也就是所在数组的下标值

        while (k>1 && less(k/2,k)){ //判断条件，1、待上浮的结点不能是根结点 2、待上浮的结点必须大于父节点
            exch(k/2,k);
            k=k/2;
        }
    }

    //当父节点的值小于子结点时，下沉
    public void sink(int k){

        while (k*2<=N){ //子结点的下标必须不大于数组已有数据的大小

            int j=2*k; //找到其子结点的下标

            //找到较大的那个子结点进行比较
            if (less(j,j+1)) j++;

            //如果父节点的值比最大的子结点还要大，就退出循环
            if (!less(k,j)) break;
            exch(k,j);
            k=j;//注意这里不是k=2*k
        }
    }

    //比较数组中第 i 个和第 j 个位置的大小
    public boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    //交换数组中第 i 个和第 j 个位置的数
    public void exch(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }

    public boolean isMaxHeap(){
        return isMaxHeap(1);
    }

    //判断一个数组是否可以组成一个大顶堆(递归地进行判断)
    private boolean isMaxHeap(int k){
        //退出循环的条件
        if (k>N) return true;
        //找到当前结点的左子结点和右子结点
        int left=2*k;
        int right=left+1;
        if (!less(left,k)) return false;
        if (!less(right,k)) return false;
        return isMaxHeap(left)&& isMaxHeap(right);
    }

    public void show(){
        System.out.println(Arrays.toString(pq));
    }
}
