package 第15章泛型.Erased.manipulator;

public class Manipulation {
    public static void main(String[] args){
        HasF hf=new HasF();
        Manipulator2<HasF> manipulator2=new Manipulator2<>(hf);
//        manipulator.manipulate();
        manipulator2.manipulate();
    }
}

class Manipulator<T>{
    private T obj;
    public Manipulator(T x){
        obj=x;
    }

    //Error: cannot find symbol : method f()
//    public void manipulate(){
//        obj.f();
//    }
}
/**
 *      由于有了擦除，Java编译器无法将manipulate()必须能够在obj上调用f()这一需求映射到HasF拥有f()这一事实。
 * 为了调用f(),我们必须协助泛型类，给定泛型类的边界，以此告知编译器这个边界的类型
 */

class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x){
        obj=x;
    }

    public void manipulate(){
        obj.f();
    }
}
