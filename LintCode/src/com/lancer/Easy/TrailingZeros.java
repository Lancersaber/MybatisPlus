package com.lancer.Easy;

/**
 * 中文English
 * 设计一个算法，计算出n阶乘中尾部零的个数
 *
 * 样例
 * 样例  1:
 * 	输入: 11
 * 	输出: 2
 *
 * 	样例解释:
 * 	11! = 39916800, 结尾的0有2个。
 *
 * 样例 2:
 * 	输入:  5
 * 	输出: 1
 *
 * 	样例解释:
 * 	5! = 120， 结尾的0有1个。
 *
 * 挑战
 * O(logN)的时间复杂度
 */
public class TrailingZeros {

    public static void main(String[] args){
        int n=11;
        long trailing = trailing(n);
        System.out.println(n+"! = "+trailing);
        long l = trailingZeros(105);
        System.out.println(l);
    }

    //问题转换为这个数中含有多少个 5
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long sum=0;
        while (n!=0){
            sum+=n/5;
            n/=5;
        }
        return sum;
    }

    public static long trailing(int n){
        int result=1;
        for (int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }
}
