package chapter12.demo2.result;

//FutureResult 类扮演Future模式中的Future角色，用于操作返回值
//我们可以使用setResult方法设置返回值，使用getResultValue 方法获取返回值
public class FutureResult<T> extends Result<T> {

    private Result<T> result;
    private boolean ready=false;

    public synchronized void setResult(Result<T> result){
        this.result=result;
        this.ready=true;
        notifyAll();
    }


    @Override
    public synchronized T getResultValue(){
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

        return result.getResultValue();
    }

}
