package 第二章Sort.BasicSort;

import java.util.Arrays;

public class Selection extends Example {

    public static void sort(Comparable[] a){
        for (int i=0;i<a.length-1;i++){
            //minIndex始终指向最小数的索引，刚开始假设为i
            int minIndex=i;
            //因为前 i 个数已经排好序，所以这里j直接从i+1开始比较
            for (int j=i+1;j<a.length;j++){
                if (!less(a[minIndex],a[j])){
                    minIndex=j;
                }
            }

            exch(a,minIndex,i);
        }
    }

    public static void main(String[] args){
        int size=10;
        Integer[] a=new Integer[size];
        for (int i=0;i<size;i++){
            a[i]=(int)(Math.random()*800000);
        }
        Selection.sort(a);
        Selection.show(a);
        /*
        //第一轮选择排序
        //先假设第一个数是最小的数
        int minIndex=0;//最小数的索引
        int min=a[minIndex];
        for (int j=0+1;j<a.length;j++){
            if (a[minIndex]>a[j]){  //如果假设的最小值大于数组后面的值，则进行交换
                minIndex=j;
            }
        }
        //经过一轮循环后，最小值的索引为minIndex
        int temp=a[minIndex];
        a[minIndex]=a[0];
        a[0]=temp;
        System.out.println(Arrays.toString(a));

        //第二轮选择排序
        //先假设第一个数是最小的数
        minIndex=1;//最小数的索引
        min=a[minIndex];
        for (int j=1+1;j<a.length;j++){
            if (a[minIndex]>a[j]){  //如果假设的最小值大于数组后面的值，则进行交换
                minIndex=j;
            }
        }
        //经过一轮循环后，最小值的索引为minIndex
        temp=a[minIndex];
        a[minIndex]=a[1];
        a[1]=temp;
        System.out.println(Arrays.toString(a));

        //第三轮选择排序
        //先假设第一个数是最小的数
        minIndex=2;//最小数的索引
        min=a[minIndex];
        for (int j=1+1;j<a.length;j++){
            if (a[minIndex]>a[j]){  //如果假设的最小值大于数组后面的值，则进行交换
                minIndex=j;
            }
        }
        //经过一轮循环后，最小值的索引为minIndex
        temp=a[minIndex];
        a[minIndex]=a[2];
        a[2]=temp;
        System.out.println(Arrays.toString(a));*/

    }
}
