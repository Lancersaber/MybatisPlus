package Chapter2;


/**
 *      关于虚拟机栈和本地方法栈，在java虚拟机规范中描述了两种异常：
 *      1、如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常
 *      2、如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常
 */

/**
 * 栈容量只由 -Xss 参数设定
 */
//虚拟机栈和本地方法栈OOM测试
public class JavaVMStackSOF {
    private int stackLength=1;

    public void stackleak(){
        stackLength++;
        stackleak();
    }

    public static void main(String[] args){
        JavaVMStackSOF oom=new JavaVMStackSOF();
        try {
            oom.stackleak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
