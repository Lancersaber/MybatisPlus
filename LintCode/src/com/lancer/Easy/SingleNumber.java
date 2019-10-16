package com.lancer.Easy;

import java.util.Arrays;

public class SingleNumber {

    public static void main(String[] args){
        int[] array={1,2,3,4,5,6,6,5,4,3,2};
        int i = singleNumber2(array);
        System.out.println(i);
    }

    /**
     * @param A: An integer array
     * @return: An integer
     */
    //给出 2 * n + 1个数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
    public static int singleNumber(int[] A) {

        //未考虑A为null的情况
        if (A==null || A.length==0){
            return -1;
        }

        // write your code here
        int[] B=new int[A.length];
        for (int i=0;i<A.length;i++){
            B[i]=1;
        }

        for (int i=0;i<A.length;i++){
            if (B[i]!=0){
                for (int j=0;j<A.length;j++){
                    if (A[i]==A[j] && i!=j && B[j]!=0){
                        B[i]=0;
                        B[j]=0;
                        break;
                    }
                }
            }
        }

        int target=0;
        for (int i=0;i<B.length;i++){
            if (B[i]==1){
                target=A[i];
            }
        }
        return target;
    }


    public static int singleNumber2(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];
        }
        return rst;
    }
}
