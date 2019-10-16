package chapter12.demo1;

//MethodRequest 类表示抽象化的请求
public abstract class MethodRequest<T> {
    protected final Servant servant;
    protected final FutureResult<T> future;

    protected MethodRequest(Servant servant,FutureResult<T> future){
        this.servant=servant;
        this.future=future;
    }

    public abstract void execute();
}
