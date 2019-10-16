package New.String;

//高位优先的字符串排序
public class MSD {

    public static void main(String[] args){
        String[] strings=new String[3];
        strings[0]="Shell";
        strings[0]="She";
        strings[0]="great";
        sort(strings);

    }

    private static int R=256; //基数
    private static final int M=15;// 小数组的切换阈值 ??
    private static String[] aux; //数组分类的辅助数组
    private static int charAt(String s,int d){
        if (d<s.length())
            return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a){
        int N=a.length;
        aux=new String[N];
        sort(a,aux,0,N-1,0);
    }

    private static void sort(String[] a,String[] aux,int lo,int hi,int d){
        if (hi<=lo) return;
        int[] count=new int[R+2];
        for (int i=lo;i<=hi;i++){
            count[charAt(a[i],d)+2]++;
        }

        for (int r=0;r<R+1;r++){
            count[r+1]+=count[r];
        }

        for (int i=lo;i<=hi;i++){
            aux[count[charAt(a[i],d)+1]++]=a[i];
        }

        for (int i=lo;i<=hi;i++){
            a[i]=aux[i-lo];
        }

        for (int r=0;r<R;r++){
            sort(a,aux,lo+count[r],lo+count[r+1]-1,d+1);
        }
    }
}
