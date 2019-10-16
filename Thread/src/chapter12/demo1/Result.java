package chapter12.demo1;

//Result 类相当于Future模式中的VirtualData角色。Result类有两个子类：
//扮演Future角色的FutureResult类和扮演RealData角色的RealResult 类
public abstract class Result<T> {
    public abstract T getResultValue();
}
