package com.atguigu.kmp;

public class ViolenceMatch {
    public static void main(String[] args){

    }

    //暴力匹配

    /**
     * 暴力匹配的思路
     * 1、假设现在str1匹配到i位置，字串str2匹配到j 位置，则有
     * 2、如果当前字符串匹配成功(即str1[] == str2[]),则i++，j++，继续匹配下一个字符
     * 3、如果匹配失败(即str1[i]!=str2[j]),令i=(i-j)+1,j=0。相当于每次匹配失败时，i回溯，j被置为0
     */
    public static int violenceMatch(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int s1Len=s1.length;
        int s2Len=s2.length;

        int i=0;//i索引指向s1
        int j=0;//j索引指向s2

        while (i<s1Len && j<s2Len){ //保证匹配时，不越界
            if (s1[i]==s2[j]){  //匹配成功
                i++;
                j++;
            }else {
                //没有匹配成功
                i=i-(j-1);
                j=0;
            }
        }

        //判断是否匹配成功
        if (j==s2Len){
            return i-j;
        }else {
            return -1;//表示匹配失败
        }
    }
}
