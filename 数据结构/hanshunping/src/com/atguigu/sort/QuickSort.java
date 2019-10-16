package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class QuickSort {
    private static int count=0;

    public static void main(String args[]){
//        int arr[]={-9,78,0,23,-567,-78,70};
//        quickSort(arr,0,arr.length-1);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }

        //测试快速排序的效率
        int maxSize=8;
        int test[]=new int[maxSize];
        for(int i=0;i<maxSize;i++){
            test[i]= (int)(Math.random()*100);
        }
        int[] array={21,0,15,24,15,65,11,32};
        int[] arr={1,2,3,5,12,5,64,5,6,7,8};
        System.out.println("排序前");
//        System.out.println(Arrays.toString(test));
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        String date1=simpleDateFormat.format(date);
        System.out.println("排序前的时间="+date1);

        quickSort(arr,0,arr.length-1);
        Date date2=new Date();
        String date3=simpleDateFormat.format(date);
        System.out.println("排序后的时间="+date3);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        for (int i=left;i<=right;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int l=left;//左下标
        int r=right;//右下标
        //pivot 中轴值
        int pivot=arr[(left+right)/2];
//        System.out.println("中轴值为"+pivot);
//        System.out.println("第"+(++count)+"轮,左下标为"+l+",右下标为 "+right+" 中间值为a["+(left+right)/2+"]="+pivot);

        int temp=0;
        //while循环的目的是让比pivot小的值放到pivot的左边，比pivot大的放到右边
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

    public static void sort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(left+right)/2];
        while (l<r){
            while (arr[l]<pivot){
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }

            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果其中一个指向的正好是pivot,那么下一个就无需再进行判断了
            if (arr[l]==pivot){ //说明在交换前 arr[right] 指向了pivot,而arr[left]交换的数必然不小于pivot，所以这里可以让r+1
                r--;
            }
            if (arr[r]==pivot){
                l++;
            }

            if (l>=r){
                break;
            }
        }

        System.out.println("left="+l+" right= "+r);
        if (l==r){
            l++;
            r--;
        }
        if (left<r){
            sort(arr,left,r);
        }
        if (right>l){
            sort(arr,l,right);
        }
    }
}
