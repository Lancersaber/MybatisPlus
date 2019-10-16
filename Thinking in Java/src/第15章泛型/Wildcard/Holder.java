package 第15章泛型.Wildcard;

/**
 * PECS原则
 * 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
 * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
 * 如果既要存又要取，那么就不要使用任何通配符。
 */
public class Holder<T> {
    private T value;
    public Holder(){

    }

    public Holder(T value){
        this.value=value;
    }

    public void setValue(T value){
        this.value=value;
    }

    public T getValue(){
        return value;
    }

    public boolean equals(Object object){
        return value.equals(object);
    }

    public static void main(String[] args){
        Holder<Apple> appleHolder=new Holder<Apple>(new Apple());
        Apple d=appleHolder.getValue();
        appleHolder.setValue(d);

//        Holder<Fruit> Fruit=Apple; //Cannot upcast
        Holder<? extends Fruit> fruit=appleHolder;  //OK
        Fruit p=fruit.getValue();
        d=(Apple)fruit.getValue();
        try {
            Orange c=(Orange)fruit.getValue();
        }catch (Exception e){
            System.out.println(e);
        }
        //fruit.setValue(new Apple());  Cannot call set()
        //fruit.setValue(new Orange()); Cannot call set()
        System.out.println(fruit.equals(d));    //OK
    }
}
