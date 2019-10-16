package com.lancer.Easy;

import java.util.ArrayList;
import java.util.List;

public class GetNarcissisticNumbers {

    public static void main(String[] args){
        List<Integer> narcissisticNumbers = getNarcissisticNumbers(3);
        System.out.println(narcissisticNumbers);
    }

    /**
     *  水仙花数
     *
     */
    public static List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        int start=1,end=1;
        if(n==1){
            start=0;
        }
        List<Integer> list=new ArrayList();
        for (int i=1;i<n ;i++){
            start*=10;
        }
        end=start*10-1;
        if(n==1){
            end=9;
        }
        for(int i=start;i<=end;i++){
            if(right(n,i)){
                list.add(i);
            }
        }

        return list;
    }

    public static boolean right(int n,int num){
        int[] array=new int[n];
        int sum=0;
        int temp=num;
        for(int i=0;i<n;i++){
            array[i]=num%10;
            num/=10;
            sum+=cal(n,array[i]);
        }
        return temp==sum;
    }

    public static int cal(int n,int num){
        int sum=num;
        for(int i=1;i<n;i++){
            sum*=num;
        }
        return sum;
    }
}
