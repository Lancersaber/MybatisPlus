package chapter12.demo1;

//DisplayStringRequest类是表示 “显示字符串”的类
public class DisplayStringRequest extends MethodRequest<Object> {

    private final String string;

    public DisplayStringRequest(Servant servant,String string){
        super(servant,null);
        this.string=string;
    }

    @Override
    public void execute() {
        servant.displayString(string);
    }
}
