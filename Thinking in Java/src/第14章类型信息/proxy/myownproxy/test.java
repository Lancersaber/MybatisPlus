package 第14章类型信息.proxy.myownproxy;

public class test {

    public static void main(String[] args){
        test t=new test();
        String s=t.getClass().getResource("").getPath();
        System.out.println(s);
    }
}
