package Chapter2_线性表.顺序表;

/**
 *  给定一个含n(n>= 1)个整数的数组，请设定一个在时间上尽可能高效的算法，找出数组中未出现的最小正整数
 *  如 数组{-5,3,2,3} 中未出现的最小正整数是1
 *     数组{1,2,3}中未出现的最小正整数是4
 */
public class Problem13 {

    public static void main(String[] args){
//        int[] array={-5,3,2,3};
        int[] array={-9,1,2,4,887};
        int minNUmber = getMinNUmber(array);
        System.out.println(minNUmber);
    }

    public static int getMinNUmber(int[] array){
        int result=1;
        boolean change=false;
        int i=0;
        while (true){
            for (i=0;i<array.length;i++){
                if (result==array[i]){
                    change=true;
                    break;
                }
            }

            if (i==array.length || !change){
                break;
            }else {
                result++;
            }

//            if (i==array.length){
//                break;
//            }
//
//            if (change){
//                result++;
//            }else {
//                break;
//            }
        }
        return result;
    }
}
