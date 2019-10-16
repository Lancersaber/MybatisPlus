package chapter11.demo1;

/**
 *      Java.lang.ThreadLocal 的实例当作一种集合可能会有助于理解。也就是说，一个ThreadLocal的实例会管理多个对象。
 * 为了更好的理解，可以将java.lang.ThreadLocal 的实例看作储物间。这里的重点在于它并非一个储物柜，而是一个有着许多
 * 储物柜的储物间。
 *      由于一个ThreadLocal 的实例可以管理多个对象，所以ThreadLocal定义了可以“存储(set)”和“获取”(get)对象的方法。
 * 下面来讲解这两个方法。
 *      set方法
 *      ThreadLocal类的set方法可以通过参数接收的实例与调用该方法的线程(当前线程)对应并存储起来。这里存储的对象可以通过get方法
 * 获取。set方法中没有表示线程的参数。set方法会先查询当前线程(即表达式Thread.currentThread())的值，然后以它作为键来存储实例。
 *      调用set方法就相当于将自己的行李放置到自己的存储柜中。
 *
 *      Get方法
 *      ThreadLocal类的get方法用于获取与调用get方法的线程(当前线程)对应的实例。该线程之前通过set方法存储的实例就是get方法的
 * 返回值。如果之前一次都没有调用过set方法，则get方法的返回值为null。
 *      与set方法一样，get方法中也没有表示线程的参数。这是因为，get方法也会去查询当前线程。即get方法会以当前线程自身为键去获取
 * 对象。
 *      调用get方法相当于从自己的储物柜中取出自己的行李。
 */
public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    //写日志
    public static void println(String s){
        getTSLog().println(s);
    }

    //关闭日志
    public static void close(){
        getTSLog().close();
    }

    //获取线程的特有的日志
    private static TSLog getTSLog(){
        TSLog tsLog=tsLogCollection.get();

        //如果该线程是第一次调用本方法，就新生成并注册一个日志
        if (tsLog == null){
            tsLog=new TSLog("C:\\Users\\34689\\Desktop\\"+Thread.currentThread().getName()+" -log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
