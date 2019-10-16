package 第16章数组.multidimensional_arrays;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {

    public static void main(String[] args){
        int[][] a={
                {1,2,3},
                {4,5,6}
        };
        //Arrays.deepToString()可以将多维数组转换为多个String
        System.out.println(Arrays.deepToString(a));
    }
}
