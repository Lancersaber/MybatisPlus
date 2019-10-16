package com.lancer.hard;

/**
 * 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。
 * 如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数。
 */
public class Atoi {

    public static void main(String[] args){

        String s=" -999.99";
        int i = atoi1(s);
        System.out.println(i);
    }

    public static int atoi(String s) {
        // write your code here
        Integer result=0;
        try{
            if ( !s.matches("-?\\d+") && !s.matches("\\+?\\d+") ){
                if (!s.matches("-?\\d+.?\\d+") && !s.matches("\\+?\\d+.?\\d+") ){
                    //既不是整数，也不是分数
                    return 0;
                }else {
                    s=s.substring(0,s.indexOf("."));
                }
            }
            result=Integer.parseInt(s);
        }
        catch(Exception e){
            if (s.indexOf(0)=='-'){
                result=Integer.MIN_VALUE;
            }
            else
                result=Integer.MAX_VALUE;
        }

        return result;

    }

    public static int atoi1(String s) {
        // write your code here
        Integer result=0;
        int t=0;
        try{
            if (!s.matches("-?\\d+") && !s.matches("\\+?\\d+")){
                StringBuilder stringBuilder=new StringBuilder("");
                for (int i=0;i<s.length();i++){
                    while (" ".equals(s.substring(i,i+1))){
                        if (i<s.length()-1){
                            i++;
                            t=i;
                        }else {
                            break;
                        }
                    }
                    if (t==i&& ("-".equals(s.substring(i,i+1)) || "+".equals(s.substring(i,i+1)))){
                        stringBuilder.append(s.substring(i,i+1));
                        continue;
                    }
                    if (s.substring(i,i+1).matches("\\d+")||" ".equals(s.substring(i,i+1))){
                        if (!" ".equals(s.substring(i,i+1))){
                            stringBuilder.append(s.substring(i,i+1));
                        }
                    }
                    else
                        break;
                }
                s=stringBuilder.toString();
            }
            result=Integer.parseInt(s);
        }
        catch(Exception e){
            if ("".equals(s)||"+".equals(s)||"-".equals(s))
                return 0;
            if ("-".equals(s.substring(0,1))){
                result=Integer.MIN_VALUE;
            }
            else
                result=Integer.MAX_VALUE;
        }

        return result;

    }
}
