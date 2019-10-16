package 第二章Sort.BasicSort;

/**
 * 下面的Example类是排序算法的模板
 */
public class Example{

    public static void sort(Comparable[] a){

    }

    //如果v比w小就返回true，否则返回false
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public   static void show(Comparable[] a){//在单行打印数组
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    //测试数组元素是否有序
    public static boolean isSorted(Comparable[] a){
        for (int i=1;i<a.length;i++){
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
}
/**
 *  排序成本模型
 *  在研究排序算法时，我们需要计算比较和交换的次数。对于不交换的算法，我们会计算访问数组的次数。
 */
