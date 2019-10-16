package Chapter2_线性表.顺序表;

/**
 * 求两个等长的升序序列的中位数
 */
public class Problem11 {

    public int getTarget(int[] A,int[] B){
        //定义一个数组，将A，B的元素全部拷贝到这个数组中
        int[] temp=new int[A.length+B.length];
        int index=0,i=0,j=0;
        int targetIndex=A.length;
        int result=0;
        while (index!=targetIndex){
            if (A[i]<B[j]){
                i++;
                index++;
            }

            if (B[j]<A[i]){
                j++;
                index++;
            }

            if (A[i]==B[j]){
                i++;
                j++;
                index+=2;
            }
        }

        return result;
    }

}
