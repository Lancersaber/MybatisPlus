package chapter10.demo2;

//使用"未捕获的异常的处理器"和"退出钩子"的Main类
public class Main {
    public static void main(String[] args){
        System.out.println("main:BEGIN");

        //1、设置未捕获的异常的处理器
        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler(){
                    @Override
                    public void uncaughtException(Thread thread, Throwable exception) {
                        System.out.println("****");
                        System.out.println("UncaughtExceptionHandle:BEGIN");
                        System.out.println("currentThread = "+Thread.currentThread());
                        System.out.println("thread = "+thread);
                        System.out.println("exception = "+exception);
                        System.out.println("UncaughtExceptionHandle:END");
                    }
                }
        );

        //2、设置退出钩子
        Runtime.getRuntime().addShutdownHook(
                new Thread(){
                    public void run(){
                        System.out.println("***");
                        System.out.println("shutdown hook:BEGIN");
                        System.out.println("currentThread = "+Thread.currentThread());
                        System.out.println("shutdown hook:END");
                    }
                }
        );

        //3、大约3秒后启动执行“整数除零计算”的线程
        new Thread("MyThread"){
            public void run(){
                System.out.println("MyThread: BEGIN");
                System.out.println("MYThread: SLEEP...");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }

                System.out.println("MyThread:DIVIDE");

                //整数除零计算
                int x=1/0;

                //不会来这里
                System.out.println("MyThread: END");
            }
        }.start();

        System.out.println("main:END");
    }
}
