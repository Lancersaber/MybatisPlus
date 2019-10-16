package 第二章Sort.BasicSort;

import java.util.Arrays;

public class Shell extends Example{

    public static void sort(Comparable[] a){

    }

    public static void main(String[] args){
        int[] s={8,9,1,7,2,3,5,4,6,0};
        System.out.println(Arrays.toString(s));
        //第一轮排序
        int gap=1;
        while (gap<s.length/3){
            gap=gap*3+1;
        }
//        System.out.println(gap);
        //第一轮gap=13
        int times=1;
        while (gap>=1){
            System.out.printf("第%d轮的间隔为%d\n",times,gap);
            for (int i=gap;i<s.length;i++){ //i所指的数为目标数字
                for (int j=i-gap;j>=0;j-=gap){ //j所指是i所指的数的前一个数
//                    System.out.println("["+s[j]+","+s[j+gap]+"]");
                    int target=s[j+gap];//保存目标值
                    s[j+gap]=s[j]; //将s[i]的值变为s[j]
                    int targetIndex=j+gap;
                    while (targetIndex>=gap && target<s[targetIndex-gap]){
                        s[targetIndex]=s[targetIndex-gap];
                        targetIndex-=gap;
                    }
                    s[targetIndex]=target;
//                    if (s[j]>s[j+gap]){
//                        int temp=s[j];
//                        s[j]=s[j+gap];
//                        s[j+gap]=temp;
//                    }
                }
            }
            System.out.printf("第%d轮排序后数组如下\n",times);
            System.out.println(Arrays.toString(s));
            times++;
            gap=(gap-1)/3;
        }
    }
}
