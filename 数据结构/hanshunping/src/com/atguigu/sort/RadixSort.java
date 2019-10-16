package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

    public static void main(String args[]){
//        int [] arr={53,3,542,748,14,214};
//        radixSort(arr);
        int maxSize=8000000;
        int []array=new int[maxSize];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*800000);//生成0~800000之间的数
        }

        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date);
        System.out.println("排序前的时间是"+date1Str);

        radixSort(array);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是"+date2Str);
    }

    //基数排序方法
    public static void radixSort(int[] arr){
        /*
        //第一轮(针对每个元素的个位进行排序处理)

        //定义一个二维数组，表示10个数，每个桶表示一个一维数组
        int [][] bucket=new int[10][arr.length];

        //为了记录每个桶实际存放了多少个数据，我们定义一个一维数组来记录每次放入数据的个数
        int[] bucketelemtCounts=new int[10];
        for(int j=0;j<arr.length;j++){
            //取出每个元素的个位数
            int digitOfElement=arr[j]%10;
            bucket[digitOfElement][bucketelemtCounts[digitOfElement]]=arr[j];
            bucketelemtCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下表依次取出数据，放入原来数组)
        int index=0;
        //遍历每一桶，并将桶中的数据，放入原数组
        for (int k=0;k<bucketelemtCounts.length;k++){
            //如果桶中有数据，我们才放入到原数组
            if(bucketelemtCounts[k]!=0){
                //循环该桶即第k个桶
                for (int l=0;l<bucketelemtCounts[k];l++){
                    //取出元素放入到arr
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后，需要将每个bucketelemtCounts[k]=0!!!
            bucketelemtCounts[k]=0;
        }
        System.out.println("第1轮");
        System.out.println(Arrays.toString(arr));

        //==================================
        //第二轮(针对每个元素的个位进行排序处理)
        index=0;
        for(int j=0;j<arr.length;j++){
            //取出每个元素的个位数
            int digitOfElement=arr[j]/10%10;
            bucket[digitOfElement][bucketelemtCounts[digitOfElement]]=arr[j];
            bucketelemtCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下表依次取出数据，放入原来数组)
        //遍历每一桶，并将桶中的数据，放入原数组
        for (int k=0;k<bucketelemtCounts.length;k++){
            //如果桶中有数据，我们才放入到原数组
            if(bucketelemtCounts[k]!=0){
                //循环该桶即第k个桶
                for (int l=0;l<bucketelemtCounts[k];l++){
                    //取出元素放入到arr
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            bucketelemtCounts[k]=0;
        }
        System.out.println("第2轮");
        System.out.println(Arrays.toString(arr));

        //================================
        //第三轮(针对每个元素的个位进行排序处理)
        index=0;
        for(int j=0;j<arr.length;j++){
            //取出每个元素的个位数
            int digitOfElement=arr[j]/100%10;
            bucket[digitOfElement][bucketelemtCounts[digitOfElement]]=arr[j];
            bucketelemtCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下表依次取出数据，放入原来数组)
        //遍历每一桶，并将桶中的数据，放入原数组
        for (int k=0;k<bucketelemtCounts.length;k++){
            //如果桶中有数据，我们才放入到原数组
            if(bucketelemtCounts[k]!=0){
                //循环该桶即第k个桶
                for (int l=0;l<bucketelemtCounts[k];l++){
                    //取出元素放入到arr
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            bucketelemtCounts[k]=0;
        }
        System.out.println("第3轮");
        System.out.println(Arrays.toString(arr));*/

        //根据前面的推导过程，我们就可以得到最终的基数排序代码
        //1、得到数组中最大的数的位数
        int max=arr[0]; //假设第一个数是最大值
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength=(max+"").length();
        //定义一个二维数组，表示10个数，每个桶表示一个一维数组
        int [][] bucket=new int[10][arr.length];

        //为了记录每个桶实际存放了多少个数据，我们定义一个一维数组来记录每次放入数据的个数
        int[] bucketelemtCounts=new int[10];

        //下面使用循环来进行处理
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //针对每个元素的对应位进行排序，第一次是个位，第二次是十位，依次类推
            for(int j=0;j<arr.length;j++){
                int digitOfElement=arr[j]/ n %10;
                bucket[digitOfElement][bucketelemtCounts[digitOfElement]]=arr[j];
                bucketelemtCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下表依次取出数据，放入原来数组)
            int index=0;
            //遍历每一桶，并将桶中的数据，放入原数组
            for (int k=0;k<bucketelemtCounts.length;k++){
                //如果桶中有数据，我们才放入到原数组
                if(bucketelemtCounts[k]!=0){
                    //循环该桶即第k个桶
                    for (int l=0;l<bucketelemtCounts[k];l++){
                        //取出元素放入到arr
                        arr[index]=bucket[k][l];
                        index++;
                    }
                }
                //第i+1轮处理后，需要将每个bucketelemtCounts[k]=0!!!
                bucketelemtCounts[k]=0;
            }

//            System.out.println("第"+(i+1)+"轮 "+Arrays.toString(arr));
        }
    }
}
