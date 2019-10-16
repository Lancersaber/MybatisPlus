package chapter12.demo2.result;


//RealResult类相当于Future模式中的RealData角色
public class RealResult<T> extends Result<T> {

    private final T resultValue;

    public RealResult(T resultValue){
        this.resultValue=resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }//实际返回的是T，在本例中代表的是String
}
