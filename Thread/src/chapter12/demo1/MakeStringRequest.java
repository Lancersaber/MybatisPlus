package chapter12.demo1;

//MakeStringRequest 类是表示 “生成字符串”的类
public class MakeStringRequest extends MethodRequest<String>{

    private final int count;
    private final char fillchar;

    protected MakeStringRequest(Servant servant, FutureResult<String> future,int count,char fillchar) {
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
