package com.lancer.hard;

import java.util.*;

public class DicesSum {

    public static void main(String[] args){
        List<Map.Entry<Integer, Double>> entries = dicesSum(3);
        System.out.println(entries);
    }

    public static List<Map.Entry<Integer, Double>> dicesSum1(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        //存放各个不同的结果以及对应出现的次数
        Map<Integer,Integer> map1=new HashMap<>();
        //存放各个不同的结果以及对应的概率
        Map<Integer,Double> map2=new HashMap<>();
        List<Map.Entry<Integer,Double>> list=new ArrayList<>();
        return list;
    }

    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair.
        List<Map.Entry<Integer, Double>> results =
                new ArrayList<Map.Entry<Integer, Double>>();

        double[][] f = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; ++i)
            f[1][i] = 1.0 / 6;

        for (int i = 2; i <= n; ++i)
            for (int j = i; j <= 6 * n; ++j) {
                for (int k = 1; k <= 6; ++k)
                    if (j > k)
                        f[i][j] += f[i - 1][j - k];

                f[i][j] /= 6.0;
            }

        for (int i = n; i <= 6 * n; ++i)
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, f[n][i]));

        return results;
    }
}
