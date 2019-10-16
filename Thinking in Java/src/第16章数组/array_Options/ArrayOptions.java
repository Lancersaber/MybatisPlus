package 第16章数组.array_Options;

import 第16章数组.ContainerComparision.BerylliumSphere;

import java.util.Arrays;

public class ArrayOptions {

    public static void main(String[] args){
        //Arrays of objects
        BerylliumSphere[] a; //local uninitialized variable
        BerylliumSphere[] b=new BerylliumSphere[5];//The references inside the array are automatically initialized to null
        System.out.println("b: "+ Arrays.toString(b));

        BerylliumSphere[] c=new BerylliumSphere[4];
        for (int i=0;i<c.length;i++){
            if (c[i] ==null){   //can  for null reference
                c[i]=new BerylliumSphere();
            }
        }

        //Aggregate(集合；聚集；合计) initialization
        BerylliumSphere[] d={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        //Dynamic aggregate(集合；聚集；合计) initialization
        a=new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};

        System.out.println("a.length = "+a.length);
        System.out.println("b.length = "+b.length);
        System.out.println("c.length = "+c.length);
        System.out.println("d.length = "+d.length);
        a=d;
        System.out.println("a.length = "+a.length);
    }
    /**
     * 数组基本的知识总结
     * 1、对象数组和基本类型数组在使用上几乎是相同的；唯一的区别就是对象保存的是引用，基本类型数组直接保存基本类型的值
     * 2、新生成一个数组对象时，其中所有的引用被自动初始化为null；所以检查其中的引用是否为null，即可知道某个位置是否存有对象。同样，
     * 基本类型的数组如果是数值型的，就被自动初始化为0，如果是字符型的(char)的，就被自动初始化为(char)0,如果是布尔型的，就被自动初始化为false。
     */
}
