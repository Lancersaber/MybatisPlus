package 第15章泛型.simpleDemo;

public class Holder3<T> {//T 就是类型参数
    private T a;
    public Holder3(T a){
        this.a=a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}
