package 第15章泛型.Wildcard;

public class CovariantArrays {

    //数组的一种特殊行为，可以向导出类型的数组赋予基本类型的数组引用
    public static void main(String[] args){
        Fruit[] fruits=new Apple[10];
        fruits[0]=new Apple(); //OK
        fruits[1]=new Jonathan(); //OK
        //Runtime type is Apple[],not Fruit[] or Orange[]
        try {
            //Compiler allows you to add Fruit:
            fruits[0]=new Fruit();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class Fruit{

}

class Apple extends Fruit{

}

class Jonathan extends Apple{

}

class Orange extends Fruit{

}
