package 第15章泛型.generator;

//泛型也可以用于接口，例如生成器
public interface Generator<T> {
    T next();
}
