package 第13章String.FormatPrint;

public class SimpleFormat {

    public static void main(String[] args){
        int x=5;
        double y=5.332542;
        //The old way
        System.out.println("Row 1: ["+x+" "+y+"]");
        //The new way
        System.out.printf("Row 1: [%d %f]\n",x,y);
        //or
        System.out.format("Row 1: [%d %f]\n",x,y);
    }
}
