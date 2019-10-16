package Chapter2_线性表.顺序表;

import java.util.Arrays;

/**
 * 将两个有序顺序表合并为一个新的有序顺序表
 */
public class Problem7 {

    public static void main(String[] args){
        int[] A={1,3,5,7,9};
        int[] B={2,4,6,8,10};
        int[] combine = combine(A, B);
        System.out.println(Arrays.toString(combine));
    }

    public static int[] combine(int[] A,int[] B){
        int[] array=new int[A.length+B.length];
        int i=0,j=0,index=0;
        while (index!=array.length){
            if (j==B.length|| A[i]<B[j]){
                array[index++]=A[i];
                i++;
            }

            if ( i==A.length||B[j]<A[i]){
                array[index++]=B[j];
                j++;
            }

            if (i!=A.length && j!=B.length && A[i]==B[j]){
                array[index++]=A[i];
                array[index++]=B[j];
                i++;
                j++;
            }
        }

        return array;
    }
}
