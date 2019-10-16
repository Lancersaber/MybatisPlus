package com.lancer.Medium;

/**
 * 4. 丑数 II
 * 中文English
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 *
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 *
 * 样例
 * 样例 1：
 *
 * 输入：9
 * 输出：10
 * 样例 2：
 *
 * 输入：1
 * 输出：1
 * 挑战
 * 要求时间复杂度为 O(nlogn) 或者 O(n)。
 *
 * 注意事项
 * 我们可以认为 1 也是一个丑数。
 */
public class NthUglyNumber {

    public static void main(String[] args){
        int i = nthUglyNumber(7);
        System.out.println(i);
//        boolean uglyNumber = isUglyNumber(9);
//        System.out.println(uglyNumber);
//        System.out.println(9%3);
    }

    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public static int nthUglyNumber(int n) {
        // write your code here
        int count=0,target=1;
        while (count!=n){
            System.out.println("target = "+target+" count="+count);
            if (isUglyNumber(target)){
                count++;
            }
            if (count!=n){
                target++;
            }
        }
        return target;
    }

    public static boolean isUglyNumber(int n){
        boolean bool=false;
//        System.out.println("isUglyNumber n="+n);
        if (n==1){
            bool=true;
        }

        while (n!=1){
//            System.out.println("n="+n);
            if (n%5!=0 && n%3!=0 && n%2!=0){
//                System.out.println(n);
                break;
            }

            if (n%5==0){
                n/=5;
//                System.out.println("n="+n);
            }
            if (n%3==0){
                n/=3;
//                System.out.println("n="+n);
            }
            if (n%2==0){
                n/=2;
//                System.out.println("n="+n);
            }
        }

        if (n==1){
            bool=true;
        }

        return bool;
    }
}
