package Lambda;


import org.junit.jupiter.api.Test;

/**
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符"->" 该操作符称为箭头操作符或Lambda操作符，箭头操作符将Lambda 表达式拆分成两部分
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能，即Lambda 体
 *
 * 语法格式1：无参数，无返回值的
 *          ()->
 *
 * 语法格式2：有一个参数，无返回值
 */
public class TestLambda2 {

    public static void main(String[] args){

    }

    @Test
    public void test01(){
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        System.out.println("============================");

        Runnable runnable=()->System.out.println("hello");
        Thread thread=new Thread(runnable);
        thread.start();
    }
}