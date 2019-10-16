package 第二章Sort.BasicSort;

import 第一章基础知识.Utils;

public class Test {

    public static void main(String[] args){
//        int size=20;
//        Integer[] a=new Integer[size];
//        for (int i=0;i<size;i++){
//            a[i]=(int)(Math.random()*100);
//        }
//
//        System.out.println(Arrays.toString(a));
//        Quick3Way(a);
//        System.out.println(Arrays.toString(a));
//        String dest="BAAAAAAAAAAAAAAAAAAAA";
//        int[] ints = kmpNext(dest);
//        System.out.println(Arrays.toString(ints));

        String regex="^[A-Z].*[0-9]{3}$";
        String string="A b cccccccccccc11a111";
        boolean match = Utils.isMatch(regex, string);
        System.out.println("match = "+match);
        String[] split = string.split("A\b");
        System.out.println(split.length);
        for (String s:split){
            System.out.println(s);
        }
    }

    public static void sort(int[] a){
        int[] aux=new int[a.length];
        sort(a,aux,0,a.length-1);
    }

    private static void sort(int[] a,int[] aux,int lo,int hi){
        //确定递归退出的条件
        if (hi<=lo){
            return;
        }
        int mid=(lo+hi)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    private static void merge(int[] a,int[] aux,int lo,int mid,int hi){
        //将数组a的内容从lo 到 hi 依次拷贝到辅助数组aux中
        for (int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }

        int i=lo,j=mid+1;
        for (int k=lo;k<=hi;k++){   //k 始终是用于数组a的,由于这里的for循环已经进行k++了，所以无需再循环中再进行 k++的操作
            if (i>mid){ //说明左半部分已经遍历完
                a[k]=aux[j++];
            }else if (j>hi){ //说明右半部分已经遍历完
                a[k]=aux[i++];
            }else if (aux[i]>aux[j]){
                a[k]=aux[j++];
            }else {
                a[k]=aux[i++];
            }
        }
    }

    public static void Quick3Way(Comparable[] a){
        Quick3Way(a,0,a.length-1);
    }

    //Quick3Way
    private static void Quick3Way(Comparable[] a,int lo,int hi){
        if (hi<=lo){
            return;
        }
        int lt=lo,gt=hi;
        int i=lo+1;
        Comparable v=a[lo];
        while (i<=gt){
            int cmp=a[i].compareTo(v);
            if (cmp<0){ //说明a[i]< v
                exch(a,i++,lt++);
            }else if (cmp>0){
                exch(a,i,gt--);
            }else i++;
        }

        Quick3Way(a,lo,lt-1);
        Quick3Way(a,gt+1,hi);
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static int[] kmpNext(String dest){
        int[] next=new int[dest.length()];
        next[0]=0;
        for (int i=1,j=0;i<next.length;i++){
            System.out.println(dest.charAt(i)+"     "+dest.charAt(j));

            //AACDAAD
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                System.out.println("j = "+j);
                j=next[j-1];
            }

            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
            System.out.println("=======================");
        }
        return next;
    }


}
