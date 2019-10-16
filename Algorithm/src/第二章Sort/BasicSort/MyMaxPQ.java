package 第二章Sort.BasicSort;

public class MyMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; //基于堆的完全二叉树
    private int N=0; //存储与pq[1..N]中，pq[0]没有使用

    public MyMaxPQ(int maxN){
        pq=(Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void insert(Key v){
        pq[++N]=v;
        swim(N);
    }

    public Key delMax(){
        if (N==0){
            throw new RuntimeException("数组已为空");
        }
        Key max=pq[1];  //从根结点得到最大元素
        exch(1,N--);    //将其和最后一个结点交换，交换完后将N-1
        pq[N+1]=null;    //防止越界
        sink(1);    //恢复堆的有序性
        return max;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    public void show(){
        for (int i=1;i<=N;i++){
            System.out.print(pq[i]+" ");
        }
    }

    private void exch(int i,int j){
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    //由下向上的堆有序化
    //堆的有序状态因为某个结点变得比它的父节点更大而被打破（即这默认是个大顶堆）
    private void swim(int k){
        while (k>1 && less(k/2,k) ){ // 这里k不能等于1是因为如果k=1，k/2=0，而pq[0]没有存放数据，所以不能写k>=1
            exch(k/2,k);//k/2一定能到达k结点的父节点
            k=k/2;
        }
    }

    //由上至下的堆有序化(下沉)
    //堆的有序状态因为某个结点变得比它的两个子结点或者其中之一更小了而被打破 (即大顶堆)
    private void sink(int k){
        while (2*k<=N){
            int j=2*k;
            if (j<N && less(j,j+1)){
                j++;//找到目标结点的较大的子结点
            }
            if (!less(k,j)){//如果较大的子结点小于目标结点，就break，如果大于目标结点，就交换
                break;
            }
            exch(k,j);
            k=j;
        }
    }

    public static void main(String[] args){
//        Integer[] array = Utils.createArray(10);
        MyMaxPQ<Integer> array=new MyMaxPQ<>(10);
        for (int i=0;i<5;i++){
            array.insert(110-10*i);
        }
        array.show();
        for (int i=0;i<3;i++){
            array.delMax();
            System.out.println();
            array.show();
        }
    }
}
