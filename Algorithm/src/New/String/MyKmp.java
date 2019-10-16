package New.String;

public class MyKmp {

    public static void main(String[] args){
        String s="ababaaaba";
        int[] next = getNext(s);
        for (int i=1;i<next.length;i++){
            System.out.print(next[i]+" ");
        }
    }

    public static int[] getNext(String T){
        int[] next=new int[T.length()];
        int i,j;
        i=1;
        j=0;
        next[0]=0;
        while (i<T.length()){

            if (j==0 || T.charAt(i)==T.charAt(j)){ //T.charAt(i) 表示后缀的单个字符
                                                    //T.charAt(j) 表示前缀的单个字符
                ++j;
                next[i]=j;
                ++i;

            }else {
                j=next[j]; //若字符不同，则j 值回溯
            }
        }

        return next;
    }
}
