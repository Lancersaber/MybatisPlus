package chapter12.demo2.MethodRequest;


import chapter12.demo2.ActiveObject.Servant;
import chapter12.demo2.result.FutureResult;
import chapter12.demo2.result.Result;

//MakeStringRequest 类是表示 “生成字符串”的类
public class MakeStringRequest extends MethodRequest<String>{

    private final int count;
    private final char fillchar;

    public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
        super(servant, future);
        this.count=count;
        this.fillchar=fillchar;
    }

    @Override
    public void execute() {
        Result<String> result=servant.makeString(count,fillchar);
        future.setResult(result);
    }
}
