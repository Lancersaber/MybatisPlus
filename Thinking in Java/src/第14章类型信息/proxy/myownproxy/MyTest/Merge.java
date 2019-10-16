package 第14章类型信息.proxy.myownproxy.MyTest;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args){
        int arr[]={9,8,7,6,5,4,3,2,100,21,45,56,11,0,9,1,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a,int[] aux,int lo,int hi){

        if (lo>=hi){
            return;
        }

        int mid=(lo+hi)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    public static void sort(int[] a){
        int[] aux=new int[a.length];
        sort(a,aux,0,a.length-1);
    }


    /**
     *
     * @param a 待归并的数组
     * @param aux   辅助数组
     * @param lo    指向左半部分数组
     * @param mid   分割数组a
     * @param hi    指向右半部分数组
     */
    public static void merge(int[] a,int[] aux,int lo,int mid,int hi){

        for (int i=lo;i<=hi;i++){
            aux[i]=a[i];
        }
        int i=lo,j=mid+1;
        for (int k=lo;k<=hi;k++){
            if (i>mid) {
                a[k]=aux[j++];
            }else if (j>hi){
                a[k]=aux[i++];
            }else if (aux[i]<aux[j]){
                a[k]=aux[i++];
            }else {
                a[k]=aux[j++];
            }
        }
    }
}
