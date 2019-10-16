package 第16章数组.multidimensional_arrays;

import java.util.Arrays;
import java.util.Random;

public class RaggedArray {

    public static void main(String[] args){
         //数组中构成矩阵的每个向量都可以具有任意的长度(这被称为粗糙数组)
        Random rand=new Random(48);
        //3-D array with varied-length(7)[][]
        int[][][] a=new int[rand.nextInt(7)][][];
        System.out.println("a.length = "+a.length);
        for (int i=0;i<a.length;i++){
            a[i]=new int[rand.nextInt(5)][];
            System.out.println("a["+i+"].length = "+a[i].length);
            for (int j=0;j<a[i].length;j++){
                a[i][j]=new int[rand.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
