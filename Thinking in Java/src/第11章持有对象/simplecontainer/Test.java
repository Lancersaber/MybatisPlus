package 第11章持有对象.simplecontainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Test {

    public static void main(String[] args){
        Collection<Integer> collection=new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(1);
        System.out.println(collection);
    }
}
