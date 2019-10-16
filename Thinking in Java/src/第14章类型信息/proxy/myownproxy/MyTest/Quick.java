package 第14章类型信息.proxy.myownproxy.MyTest;

import java.util.Arrays;

public class Quick {

    public static void main(String[] args){
        int arr[]={9,8,7,6,5,4,3,2,100,21,45,56,11,10,99,1,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(int[] a,int lo,int hi){
        if (lo>=hi)
            return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static int partition(int[] a, int lo,int hi ){
        int i=lo,j=hi+1;

        while (true){
            while (a[++i]<a[lo]){
                if (i==hi)
                    break;
            }

            while (a[lo]<a[--j]){
                if (j==lo)
                    break;
            }

            if (i>=j){
                break;
            }

            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        int temp=a[lo];
        a[lo]=a[j];
        a[j]=temp;
        return j;
    }
}
