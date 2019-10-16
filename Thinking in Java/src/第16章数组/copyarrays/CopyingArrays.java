package 第16章数组.copyarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class CopyingArrays {

    public static void main(String[] args){
        int[] i=new int[7];
        int[] j=new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,99);

        System.out.println("i = "+Arrays.toString(i));
        System.out.println("j = "+Arrays.toString(j));
        System.arraycopy(i,0,j,0,i.length);
        System.out.println("j = "+Arrays.toString(j));
        /**
         * arraycopy()需要的参数有：源数组，表示从源数组中的什么位置开始复制的偏移量，目标数组，表示从目标数组的什么位置开始复制的偏移量，以及需要复制的个数。
         * 这个函数可以拷贝基本类型数组和对象数组，然而，如果复制对象数组，那么只是复制了对象的引用--而不是对象拷贝的本身。这被称为浅拷贝
         * System.arraycopy()不会执行自动包装和自动拆包，两个数组必须具有相同的类型
         */
    }
}
