package chapter12.demo1;

//运行测试的Main类
public class Main {
    public static void main(String[] args){
        ActiveObject activeObject=ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice",activeObject).start();
        new MakerClientThread("Bobby",activeObject).start();
        new DisplayClientThread("Chris",activeObject).start();
    }
}
