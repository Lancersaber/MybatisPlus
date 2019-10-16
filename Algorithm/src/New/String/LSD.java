package New.String;

import java.util.Arrays;

//低位优先的字符串排序
//低位优先的字符串排序算法能够稳定地将定长字符串排序
public class LSD {

    public static void main(String[] args){
        String[] a=new String[13];
        a[0]="4PGC938";
        a[1]="2IYE230";
        a[2]="3CIO720";
        a[3]="1ICK750";
        a[4]="1OHV845";
        a[5]="4JZY524";
        a[6]="1ICK750";
        a[7]="3CIO720";
        a[8]="1OHV845";
        a[9]="1OHV845";
        a[10]="2RLA629";
        a[11]="2RLA629";
        a[12]="3ATW723";
        sort(a,a[0].length());
        System.out.println(Arrays.toString(a));
    }

    public static void sort(String[] a,int W){
        //通过前W个字符将a[] 排序
        int N=a.length;
        int R=256;
        String[] aux=new String[N];

        for (int d=W-1;d>=0;d--){
            //根据第 d 个字符用键索引计数法排序
            int[] count=new int[R+1]; //计算出现频率
            for (int i=0;i<N;i++){
                count[a[i].charAt(d)+1]++;
            }
//            System.out.println(Arrays.toString(count));

            for (int r=0;r<R-1;r++){ //将频率转换为索引
                count[r+1]+=count[r];
            }

            for (int i=0;i<N;i++){ //将元素分类
                aux[count[a[i].charAt(d)]++]=a[i];
            }

            for (int i=0;i<N;i++){ //回写
                a[i]=aux[i];
            }

            System.out.println(Arrays.toString(a));
        }
    }
}
