package chapter12.demo1;

//RealResult类相当于Future模式中的RealData角色
public class RealResult<T> extends Result<T> {

    private final T resultValue;

    public RealResult(T resultValue){
        this.resultValue=resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }
}
