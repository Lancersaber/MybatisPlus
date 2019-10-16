package 第15章泛型.Erased.ErasedCompensate;

public class Erased<T> {
    /**
     * 擦除丢失了在泛型代码中执行某些操作的能力。任何在运行时需要知道确切类型信息的操作都将无法工作。
     * 因为这个错误不是在编译期捕获的，所以sun的伙伴们对这种方式并不赞成，他们建议使用显式的工厂，并限制其类型，使得只能
     * 接受实现了这个工厂的类。
     */
    private final int SIZE=100;
    public static void f(Object arg){
//        if (arg instanceof T){ } Error
//        T var=new T();    Error
//        T[] array=new T[size];    Error
//        T[] array=(T)new Object[SIZE];    Unchecked warning
    }
}
