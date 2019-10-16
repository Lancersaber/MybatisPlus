package anotherChapter6;

import java.util.Arrays;

public class Test {

    public static void main(String[] args){
        int size=10;
        int[] array=new int[size];
        for (int i=0;i<size;i++){
            array[i]=(int) (Math.random()*30);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int[] index=new int[2];
        int target=18;
        BinarySearch(0,array.length-1,target,array,index);
        System.out.println(Arrays.toString(index));
    }

    public static int[] BinarySearch(int lo,int hi,int target,int[] array,int[] indexs){
//        System.out.print("hi="+hi+" lo="+lo);
        if (hi<lo){ //说明未查询成功
//            System.out.println("hi="+hi+" lo="+lo);
            indexs[0]=hi;
            indexs[1]=lo;
            return indexs;
        }
        int mid=(lo+hi)/2;
//        System.out.println(" mid="+mid);
        if (array[mid]<target){//说明target在数组的右半边
            BinarySearch(mid+1,hi,target,array,indexs);
        }
        else if (array[mid]>target){ //说明target在数组的左半边
            BinarySearch(lo,mid-1,target,array,indexs);
        }
        else {
            indexs[0]=mid;
            indexs[1]=mid;
        }
        return indexs;
    }
}
