package 第13章String.BasicOperation;

public class BasicOperation {

    public static void main(String[] args){
        String s="Hello World! I Love Java.";
        System.out.println("s.length = "+s.length());
        for (int i=0;i<s.length();i++){
            System.out.print(s.charAt(i)+" ");
        }
        char[] chars = s.toCharArray();
        System.out.println();
        System.out.println("===================");
        for (char c:chars){
            System.out.print(c+" ");
        }

//        System.out.println(s.compareTo("My Name is Mike"));
        System.out.println();
        System.out.println(s.indexOf("World"));
        System.out.println(s.lastIndexOf("World"));
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.replace("a","python"));
        System.out.println(s.substring(0,5));
    }
}
