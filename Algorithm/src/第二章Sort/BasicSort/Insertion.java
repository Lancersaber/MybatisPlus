package 第二章Sort.BasicSort;

import java.util.Arrays;

public class Insertion extends Example {

    public static void sort(Comparable[] a){
        if (a.length<=1){
            return;
        }
        for (int i=1;i<a.length;i++){
            Comparable target=a[i];
            int targetIndex=i;
            a[targetIndex]=a[targetIndex-1];
            while (targetIndex>0 && less(target,a[targetIndex-1])){
                a[targetIndex]=a[targetIndex-1];
                targetIndex--;
            }
            a[targetIndex]=target;
        }
    }

    public static void main(String[] args){
        Integer[] a={3,2,1,5,7,0};
        Insertion.sort(a);
        Insertion.show(a);
        /*
        //第一轮插入排序
        //因为第一个数只有一个，相当于已经排好序，故从第二个数开始进行运算
        int targetIndex=1;
        int target=a[targetIndex];
        //将后面的数据往前移一位，腾出空间给待插入的数据
        a[targetIndex]=a[targetIndex-1];
        //targetIndex>0 (注意这里不能带上等于号，因为target<a[targetIndex-1]中如果targetIndex=0的话，targetIndex-1等于-1越界)保证 数组不会越界
        //因为前面的数据已经排好序，所以如果目标数据小于前面的数据(因为按理说如果有序的话就应该大于前面的数据而小于后面的数据)，就一直往前移动
        while (targetIndex>0 && target<a[targetIndex-1]){
            targetIndex--;
        }
        //当循环退出时说明已经找到了适合插入的位置
        System.out.println("targetIndex = "+targetIndex);
        a[targetIndex]=target;
        System.out.println(Arrays.toString(a));

        //第二轮插入排序
        //因为第一个数只有一个，相当于已经排好序，故从第二个数开始进行运算
        targetIndex=1+1;
        target=a[targetIndex];
        //将后面的数据往前移一位，腾出空间给待插入的数据
        a[targetIndex]=a[targetIndex-1];
        //targetIndex>0 (注意这里不能带上等于号，因为target<a[targetIndex-1]中如果targetIndex=0的话，targetIndex-1等于-1越界)保证 数组不会越界
        //因为前面的数据已经排好序，所以如果目标数据小于前面的数据(因为按理说如果有序的话就应该大于前面的数据而小于后面的数据)，就一直往前移动
        while (targetIndex>0 && target<a[targetIndex-1]){
            //将后面的数据依次往前移动
            a[targetIndex]=a[targetIndex-1];
            targetIndex--;
        }
        //当循环退出时说明已经找到了适合插入的位置
        System.out.println("targetIndex = "+targetIndex);
        a[targetIndex]=target;
        System.out.println(Arrays.toString(a));
        */

    }
}
