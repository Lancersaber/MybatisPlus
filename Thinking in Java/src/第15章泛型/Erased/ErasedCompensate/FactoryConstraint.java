package 第15章泛型.Erased.ErasedCompensate;

public class FactoryConstraint {

    public static void main(String[] args){
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}

interface Factory1<T>{
    T create();
}

class Foo2<T>{
    private T x;
    //F 必须是继承了Factory1的对象,只是针对这个方法
    public <F extends Factory1<T>> Foo2(F factory){
        x=factory.create();
    }
}

class IntegerFactory implements Factory1<Integer>{

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget{
    public static class Factory implements Factory1<Widget>{

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
