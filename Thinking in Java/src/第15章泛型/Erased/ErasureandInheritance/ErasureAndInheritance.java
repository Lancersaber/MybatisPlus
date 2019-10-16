package 第15章泛型.Erased.ErasureandInheritance;

class GenericBase<T> {

    private T element;
    public void set(T arg){
        arg=element;
    }

    public T getElement(){
        return element;
    }
}

class Derived1<T> extends GenericBase<T>{

}

//Derived2 继承自GenericBase，但是没有任何泛型类型，而编译器不会发出任何警告。警告在set()被调用时才会出现
class Derived2 extends GenericBase{ //No warning

}

//class Derived3 extends GenericBase<T>{
//
//}

public class ErasureAndInheritance{

    public static void main(String[] args){
        Derived2 d2=new Derived2();
        Object object=d2.getElement();
        d2.set(object);
    }
}
