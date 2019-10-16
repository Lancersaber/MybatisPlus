package com.lancer.Medium;

/**
 * 3. 统计数字
 * 中文English
 * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 * k = 1, n = 1
 * 输出：
 * 1
 * 解释：
 * 在 [0, 1] 中，我们发现 1 出现了 1 次 (1)。
 * 样例 2：
 *
 * 输入：
 * k = 1, n = 12
 * 输出：
 * 5
 * 解释：
 * 在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 中，我们发现 1 出现了 5 次 (1, 10, 11, 12)(注意11中有两个1)。
 */
public class DigitCounts {

    public static void main(String[] args){

    }

    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if(k<0 || 9<k){
            throw new RuntimeException("参数不正确");
        }

        int result=0;
        for (int i=0;i<=n ;i++ ) {
            result+=count(k,i);
        }

        return result;
    }

    public int count(int k,int num){
        int i=num;
        int result=0;
        if(i==0 && k==0){
            result+=1;
        }

        while(i!=0){
            if (k==i%10){
                result+=1;
            }
            i/=10;
        }

        return result;
    }
}
