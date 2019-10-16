package 第二章Sort.BasicSort;

import java.util.Arrays;

public class Merge extends Example {
    private static Comparable[] aux; //归并所需的辅助数组

    public static void sort(Comparable[] a){
        aux=new Comparable[a.length]; //一次性分配空间
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        //将数组a[lo...hi]排序
        if (lo>=hi){
            return;
        }
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid); //将左半边排序
        sort(a,mid+1,hi);//将右半边排序
        merge(a,lo,mid,hi);
    }

    public static void anotherSort(Comparable[] a){
        int N=a.length;
        aux=new Comparable[N];
        for (int sz=1;sz<N;sz*=2){
            System.out.println("sz="+sz+" 2*sz="+2*sz);
            for (int lo=0;lo<N-sz;lo+=sz*2){
                System.out.println("lo="+lo+" mid="+(lo+sz-1)+" hi="+Math.min(lo+sz+sz-1,N-1));
                merge(a,lo,lo+sz-1,Math.min(lo+sz*2-1,N-1));
            }
        }
    }

    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //将a[lo..mid] 和 a[mid+1..hi]归并
        int i=lo,j=mid+1;

        for (int k=lo;k<=hi;k++){   //将a[lo..hi]复制到aux[lo..hi]
            aux[k]=a[k];
        }

        for (int k=lo;k<=hi;k++){   //归并到a[lo..hi]
            if (i>mid){
                a[k]=aux[j++];
//                System.out.println("i="+i+" mid="+mid);
            }
            else if (j>hi){
//                System.out.println("j="+j+" hi="+hi);
                a[k]=aux[i++];
            }
            else if (less(aux[j],aux[i]))
                a[k]=aux[j++];
            else
                a[k]=aux[i++];
        }
    }

    public static void main(String[] args){
//        Integer[] array=new Integer[10];
////        for (int i=0;i<array.length;i++){
////            array[i]=(int)(Math.random()*100000);
////        }
////        sort(array);
        String[] array = "MERGESORTEXAMPLES".split("");
        System.out.println(array.length);
        anotherSort(array);
        System.out.println(Arrays.toString(array));
    }
}
