package com.lancer.Easy;

import java.util.Vector;

public class IsPopOrder {

    public static void main(String[] args){
        Vector<Integer> pushV=new Vector<>(5);
        Vector<Integer> popV=new Vector<>(5);
        pushV.add(1);
        pushV.add(2);
        pushV.add(3);
        pushV.add(4);
        pushV.add(5);

        popV.add(4);
        popV.add(5);
        popV.add(3);
        popV.add(2);
        popV.add(1);
        boolean popOrder = isPopOrder(pushV, popV);
    }

    /**
     * 问题描述
     * 输入两个整数列，按栈先进后出的方式进行取出
     * 比如输入1，2，3，4，5
     * 可能会以4，5，3，2，1的方式进行输出
     * 但是不可能以4，3，5，2，1的方式进行输出
     * 写一个程序进行判断
     * @param pushV
     * @param popV
     * @return
     */
    public static boolean isPopOrder(Vector<Integer> pushV, Vector<Integer> popV) {

        if (pushV==null || popV ==null){
            return false;
        }

        boolean order=false;
        int max=popV.get(0);
        int maxIndex=0;
        int[] index=new int[pushV.capacity()];
        for (int i=0;i<popV.capacity();i++){
            index[i]=pushV.indexOf(popV.get(i));
            if (max<popV.get(i)){
                max=popV.get(i);
                maxIndex=index[i];
            }
        }
        System.out.println("The max value is "+max+" and the max_index is "+maxIndex);
        for (int i=0;i<index.length;i++){

        }

        return true;
    }
}
