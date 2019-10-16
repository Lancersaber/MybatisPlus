package 第二章Sort.BasicSort;

import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;

public class Quick {


    public static void quickSort(Integer[] arr,int left,int right){
//        for (int i=left;i<=right;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
        int l=left;//左下标
        int r=right;//右下标
        //pivot 中轴值
        int pivot=arr[(left+right)/2];
//        System.out.println("中轴值为"+pivot);
//        System.out.println("第"+(++count)+"轮,左下标为"+l+",右下标为 "+right+" 中间值为a["+(left+right)/2+"]="+pivot);

        int temp=0;
        //while循环的目的是让比pivot小的值放到pivot的左边，比pivot大的放到右边
        if (r-l<10){
            Insertion.sort(arr);
        }else {
            while (l<r){

                //在pivot的左边一直找，找到一个大于或等于pivot的值才退出
                while (arr[l]<pivot){
                    l+=1;
                }
                //在pivot的右边一直找，找到小于等于pivot的值才退出
                while (arr[r]>pivot){
                    r-=1;
                }

                //如果l>=r说明pivot的左右两边的值已经按照左边小于等于pivot，右边全部大于等于pivot
                if(l>=r){
                    break;
                }
                //交换
                temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;

                //如果交换完后，发现这个arr[l]==pivot值相等 r--,前移
                if(arr[l]==pivot){//说明arr[r]是从一个比pivot较大的数交换过来的
                    r-=1;
                }

                //如果交换完后，发现这个arr[l]==pivot值相等 l++,后移
                if(arr[r]==pivot){
                    l+=1;
                }
            }

            //如果l==r ，必须l++，r--，否则会出现栈溢出
            if(l==r){ //说明同时指向pivot
                l++;
                r--;
            }
//        System.out.println(Arrays.toString(arr));
            //向左递归
            if(left<r){
//            System.out.println("向左排序"+"quickSort(arr,"+left+","+r+")");
                quickSort(arr,left,r);
            }
            if(right>l){
//            System.out.println("向右排序"+"quickSort(arr,"+l+","+right+")");
                quickSort(arr,l,right);
            }
        }


    }

    public static void main(String[] args){
        Integer[] array={21,0,15,24,15,65,11,32};
        int[] array1={21,0,15,24,15,65,11,32};
        //以数组中间的值为基准进行快速排序
        //第一轮
       /* int mid=array[(0+array.length-1)/2];
        System.out.println("mid="+mid);
        int lo=0;
        int hi=array.length-1;
        while (lo<hi){
            while (array[lo]<mid){
                lo++;
            }
            while (array[hi]>mid){
                hi--;
            }
            int temp=array[lo];
            array[lo]=array[hi];
            array[hi]=temp;
        }*/
       quickSort(array,0,array.length-1);
//       sort(array1,0,array1.length-1);
        System.out.println(Arrays.toString(array));

    }


}
