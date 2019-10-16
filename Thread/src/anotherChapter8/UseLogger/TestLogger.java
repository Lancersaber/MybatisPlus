package anotherChapter8.UseLogger;


import java.util.logging.Logger;

public class TestLogger {

    public static void main(String[] args){
        test01();
    }

    public static void test01(){
        /**
         * static Logger getLogger(String name)
         *          查找或创建一个logger。
         * static Logger getLogger(String name, String resourceBundleName)
         *          为指定子系统查找或创建一个logger。
         */
        Logger logger = Logger.getLogger("MyLogger");

        /**
         * 在进行信息的记录时，依信息程序的不同，会设定不同等级的信息输出。Java log比log4j的级别详细，全部定义在java.util.logging.Level里面。
         *
         * 各级别按降序排列如下：
         *
         * SEVERE（最高值）
         * WARNING
         * INFO
         * CONFIG
         * FINE
         * FINER
         * FINEST（最低值）
         * 此外，还有一个级别OFF，可用来关闭日志记录，使用级别ALL启用所有消息的日志记录。
         *
         * logger默认的级别是INFO，比INFO更低的日志将不显示。
         *
         * Logger的默认级别定义是在jre安装目录的lib下面。
         *
         * # Limit the message that are printed on the console to INFO and above.
         * java.util.logging.ConsoleHandler.level = INFO
         */
        logger.severe("严重信息");
        logger.warning("警告");
        logger.info("通知");
        logger.config("设定方面的信息");
        logger.fine("细微的信息");
        logger.finer("更细微的信息");
        logger.finest("最细微的信息");


    }
}
