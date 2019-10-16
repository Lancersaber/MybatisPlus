package chapter12.demo2.ActiveObject;


import chapter12.demo2.result.RealResult;
import chapter12.demo2.result.Result;

//Servant类是在ActiveObject一方中负责实际处理的部分
public class Servant implements ActiveObject {

    //返回一个字符串
    public Result<String> makeString(int count, char fillchar){
        char[] buffer=new char[count];
        for (int i=0;i<count;i++){
            buffer[i]=fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new RealResult<String>(new String(buffer));
    }

    @Override
    public void displayString(String string) { //打印出传入的String
        try {
            System.out.println("displayString: "+string);
            Thread.sleep(10);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
