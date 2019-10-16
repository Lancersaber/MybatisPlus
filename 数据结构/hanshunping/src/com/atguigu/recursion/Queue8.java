package com.atguigu.recursion;

import java.util.Map;
import java.util.Queue;

/**
 * 八皇后问题思路
 * 1、第一个皇后先放在第一行第一列
 * 2、第二个皇后放在第二行第一列，然后判断是否OK，如果不OK，继续放在第二列，第三列，依次把所有列放完，找到一个合适的地方
 * 3、继续第三个皇后，还是第一列、第二列...直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 * 4、当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放在第一列的所有正确解，全部得到。
 * 5、然后回头继续第一个皇后放在第二列，后面继续循环执行1，2，3，4的步骤。
 */
public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max=8;
    //定义数组array，保存皇后放置位置的结果
    int[] arr=new int[max];
    static int count;

    public static void main(String[] args){
        Queue8 queue8=new Queue8();
        queue8.check(0);
        System.out.println("一共有"+count+"种解法");
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     *
     * @param n 表示放置第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i=0;i<n;i++){
            //说明
            //1、arr[i]==arr[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2、Math.abs(n-i)== Math.abs(arr[n]-arr[i])表示判断第n个皇后是否和第i个皇后是否在同一斜线
            //3、判断是否在同一行，没有必要
            if (arr[i]==arr[n]||Math.abs(n-i)== Math.abs(arr[n]-arr[i]))
                return false;
        }
        return true;
    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if (n==max){    // 当n=8 时，其实8个皇后都已经放好了
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i=0;i<max;i++){
            //先把当前这个皇后n，放到该行的第1列
            arr[n]=i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){  //说明不冲突
                //接着放第n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行arr[n]=i; 即将第n个皇后，放置在本行的后一个位置
        }
    }
}
