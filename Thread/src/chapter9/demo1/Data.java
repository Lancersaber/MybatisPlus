package chapter9.demo1;

//Data接口是表示访问数据的方法(getContent方法)的接口，FutureData类和RealData类实现了该接口
public interface Data {
    public abstract String getContent();
}
