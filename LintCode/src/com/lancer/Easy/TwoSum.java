package com.lancer.Easy;

public class TwoSum {

    public static void main(String[] args){
        int[] array={14,2,7,12,55};
        int target=9;
       int[] index= twoSum(array,target);
        System.out.println(index[0]+" "+index[1]);
//        System.out.println(Integer.SIZE);
//        TwoSum twoSum=new TwoSum();
//        System.out.println(twoSum);
    }

    /**
     * Description
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum(int[] array,int target){
        int[] index=new int[2];
        int i=0,j=0;
        for (i=0;i<array.length;i++){
            for (j=i+1;j<array.length;j++){
                if (array[i]+array[j]==target){
                    index[0]=i;
                    index[1]=j;
                    break;
                }
            }
        }
        return index;
    }


}
