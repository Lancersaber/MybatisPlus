package 第二章Sort.BasicSort;

import java.util.Arrays;

public class SortCompare {
    public static void main(String[] args) {
        int size=50;
        int[] s =new int[size] ;
        for (int i=0;i<s.length;i++){
            s[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(s));
        //第一轮排序
        int gap = 1;
        while (gap < s.length / 3) {
            gap = gap * 3 + 1;
        }
//        System.out.println(gap);
        //第一轮gap=13
        int times = 1;
        while (gap >= 1) {
            System.out.printf("第%d轮的间隔为%d\n", times, gap);
            for (int i = gap; i < s.length; i++) {
//                for (int j = i; j <=s.length; j += gap) {
////                    System.out.println("["+s[j]+","+s[j+gap]+"]");
//                    if (j>=s.length){
//                        break;
//                    }
//                    int target = s[j];
//                    s[j] = s[j - gap];
//                    int targetIndex = j;
//                    while (targetIndex >=gap && target < s[targetIndex - gap]) {
//                        s[targetIndex] = s[targetIndex - gap];
//                        targetIndex -= gap;
//                    }
//                    s[targetIndex] = target;
                int j=i;
                do {
                    int target = s[j];
                    s[j] = s[j - gap];
                    int targetIndex = j;
                    while (targetIndex >=gap && target < s[targetIndex - gap]) {
                        s[targetIndex] = s[targetIndex - gap];
                        targetIndex -= gap;
                    }
                    s[targetIndex] = target;
                    j+=gap;
                }while (j<s.length);
//                }
            }

            System.out.printf("第%d轮排序后数组如下\n", times);
            System.out.println(Arrays.toString(s));
            times++;
            gap = (gap - 1) / 3;
        }
    }
}
