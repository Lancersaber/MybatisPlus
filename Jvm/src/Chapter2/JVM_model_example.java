package Chapter2;

public class JVM_model_example {
    private static int id=211111;//静态变量，保存在方法区
    private String name;//普通变量，方法区
    private int[] array=new int[10];//数组。堆上分配空间
    private HeapOOM heapOOM=new HeapOOM();//实例对象，在堆上分配空间




    public static void main(String[] args){
        test();
    }

    /**
     * 执行test方法时，会同时创建一个栈帧(Stack Frame),存储局部变量表、操作栈、动态链接、方法出口等信息。
     * 并且将该栈帧在虚拟机栈中入栈。(每个线程对应一个虚拟机栈)
     */
    public static void test(){
        int i=0;//存放在栈中
        String s="hello world!";//对象引用，存放在栈中
    }
}
