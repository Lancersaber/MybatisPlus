package 第一章基础知识;

public class Utils {

    public static Integer[] createArray(int size){
        Integer[] array=new Integer[size];
        for (int i=0;i<size;i++){
            array[i]=(int)(Math.random()*100);
        }
        return array;
    }

    //判断正则表达式是否匹配给定的字符串
    public static boolean isMatch(String regex,String string){
        return string.matches(regex);
    }
}
