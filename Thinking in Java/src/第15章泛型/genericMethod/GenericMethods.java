package 第15章泛型.genericMethod;

/**
 *  泛型方法
 *  一个类是否拥有泛型方法，与其所在的类是否是泛型没有关系
 *  要定义泛型方法，只需将泛型参数列表置于返回值之前
 */
public class GenericMethods {

    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    /**
     *  注意：在使用泛型类时，必须在创建对象的时候指定类型参数的值，而使用泛型方法的时候，通常不必指明参数类型，因为编译器
     * 会为我们找出具体的类型。
     */
    public static void main(String[] args){
        GenericMethods gm=new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}
