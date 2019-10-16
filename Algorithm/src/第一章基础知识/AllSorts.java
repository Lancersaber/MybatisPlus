package 第一章基础知识;

import java.util.Arrays;

public class AllSorts {

    public static void main(String[] args){
        int a[]={21,12,1,0,-90,100,22};
//        quick(a);
//        mergeSort(a);
//        System.out.println(Arrays.toString(a));
//        int select = select(a, a.length-1);
//        System.out.println(select);

        int size=60;
        int[] testArray=new int[size];
        for (int i=0;i<size;i++){
            testArray[i]=i+1;
        }
        System.out.println(Arrays.toString(testArray));
        shuffle(testArray);
        System.out.println(Arrays.toString(testArray));
        quickSort3(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    //插入排序 一个for循环 和 一个while循环
    public static void insert(int[] a){
        for (int i=1;i<a.length;i++){
            int target=a[i];
            a[i]=a[i-1];
            int targetIndex=i;
            while (targetIndex>0 &&a[targetIndex-1]>target){
                a[targetIndex]=a[targetIndex-1];
                targetIndex--;
            }
            a[targetIndex]=target;
            System.out.println(Arrays.toString(a));
        }
    }

    //希尔排序(通过交换两个元素的方式进行排序，这种方式比较简单易懂 但是效率不高)
    public static void shell01(int[] a){
        //第一步：计算间隔
        int gap=1;
        while (gap<a.length/3){
            gap=gap*3+1;
        }
        System.out.println("gap="+gap);

        //第二步:进行排序 两个for循环，1个while循环
        while (gap>=1){
            for (int i=gap;i<a.length;i++){
                for (int j=i-gap;j>=0;j-=gap){
                    if (a[j]>a[j+gap]){
                        int temp=a[j];
                        a[j]=a[j+gap];
                        a[j+gap]=temp;
                    }
                }
            }
            System.out.println(Arrays.toString(a));
            gap/=3;
        }
    }

    //希尔排序(通过交换元素的方式来进行排序)
    public static void shell02(int[] a){
        //第一步：计算间隔
        int gap=1;
        while (gap<a.length/3){
            gap=gap*3+1;
        }
        int targetIndex=-1;
        int target=0;

        while (gap>=1){
            for (int i=gap;i<a.length;i++){
                for (int j=i-gap;j>=0;j-=gap){
                    target=a[j+gap];
                    targetIndex=j+gap;  //注意这里targetIndex 的值 必须是一个大于等于gap的值
                    a[j+gap]=a[j];
                    while (targetIndex>=gap && a[targetIndex-gap]>target){ //这里targetIndex必须等于于gap，因为在循环里有targetIndex-=gap;
                        a[targetIndex]=a[targetIndex-gap];
                        targetIndex-=gap;
                    }
                    a[targetIndex]=target;
                }
            }
            System.out.println(Arrays.toString(a));
            gap/=3;
        }
    }

    //快速排序
    public static void quick(int[] a){
        quick(a,0,a.length-1);
    }

    private static void quick(int a[],int lo,int hi){
        if (lo>=hi)
            return;
        int partition = partition(a, lo, hi);
        quick(a,lo,partition-1);
        quick(a,partition+1,hi);
    }

    //选出数组中第k个大的数
    public static int select(int[] a,int k){
        int lo=0,hi=a.length-1;
        while (lo<hi){
            int i=partition(a,lo,hi);
            if (k<i) hi=i-1;
            else if (k>i) lo=i+1;
            else return a[k];
        }
        return a[k];
    }

    public static void quickSort3(int[] a){
        quickSort3(a,0,a.length-1);
    }

    //可以应对有大量重复元素的排序(也是快速排序的一种，但是比快排性能更好)
    private static void quickSort3(int[] a,int lo,int hi){
        //所有需要迭代的程序，第一步都是要确定递归返回的条件
        if (hi<=lo)
            return;
        int lt=lo,gt=hi;
        int v=a[lt];
        int i=lo;
        while (i<=gt){
            if (a[i]<v){
                exch(a,i++,lt++);
            }else if (v<a[i]){
                exch(a,i,gt--);
            }
            else i++;
        }

        quickSort3(a,lo,lt-1);
        quickSort3(a,gt+1,hi);
    }

    public static void exch(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static int partition(int a[],int lo,int hi){
        int mid=a[lo];
        int i=lo,j=hi+1;
        while (true){
            while (a[++i]<mid){
                if (i==hi)  //注意这里是i 与 hi 进行比较 ，不是与 j 进行比较
                    break;
            }

            while (a[--j]>mid){
                if (j==lo)  //注意 这里是与lo进行比较 ， 而不是与 i
                    break;
            }

            if (i>=j)
                break;
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }

        a[lo]=a[j];
        a[j]=mid;

        return j;
    }

    //打乱数组
    public static void shuffle(int[] a){
        int temp,j=0;
        for (int i=1;i<a.length;i++){ //指向第i个数，逐渐增加，直至最后一个数
            j=(int)(Math.random()*(i+1));//随机生成一个 0 - i 的值与i所指的数进行交换

            if (i!=j){
                temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
        }
    }

    /**
     *  归并排序
     *
     * @param a 待归并的数组
     * @param aux  辅助数组
     * @param lo    指向左半部分的第一个
     * @param mid   指向中间值，作为一个分界点(可以理解为左半部分的最后一个)
     * @param hi    指向右边部分的第一个树
     */
    //注意左、右半部分必须是已经排好序的
    private static void merge(int[] a,int [] aux,int lo,int mid,int hi){
        //第一步:将数组a中的值从lo到hi全部拷贝到辅助数组中
        for (int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }

        //开始进行归并
        int i=lo,j=mid+1;
        for (int k=lo;k<=hi;k++){// k的作用是作为数组 a 的下标进行赋值
            if (i>mid){
                a[k]=aux[j++];
            }else if (j>hi){
                a[k]=aux[i++];
            }else if (aux[i]<=aux[j]){//如果左半部分的值小于右半部分的值
                a[k]=aux[i++];
            }else {
                a[k]=aux[j++];
            }
        }
    }

    private static void mergeSort(int[] a,int[] aux,int lo,int hi){
        //退出循环的条件
        if (hi<=lo){
            return;
        }
        int mid=(lo+hi)/2;
        mergeSort(a,aux,lo,mid);
        mergeSort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    public static void mergeSort(int[] a){
        int[] aux=new int[a.length];
        mergeSort(a,aux,0,a.length-1);
    }


}