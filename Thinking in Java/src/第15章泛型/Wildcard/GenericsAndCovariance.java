package 第15章泛型.Wildcard;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

    public static void main(String[] args){
        List<? extends Fruit> list=new ArrayList<Apple>();
        //Compile Error : can't add any type of object
//        list.add(new Apple());
//        list.add(new Fruit());
//        list.add(new Orange());
        list.add(null);//Legal but uninteresting
        //We know that it returns at least Fruit
        Fruit f=list.get(0);
    }
}
