package 第15章泛型.anonymousTest;

import java.util.ArrayList;
import java.util.List;

public class CEO extends Manager {

    public void printC(){
        System.out.println("CEO");
    }

    public static void main(String[] args){
        List<? super Manager> list;
        list=new ArrayList<Employee>();
//        list=new ArrayList<Manager>();
        list.add(new Manager());
        list.add(new CEO());
//        list.add(new Employee()); //Error
        Object object = list.get(1);
        if (object instanceof Manager){
            ((Manager)object).printM();
        }
        if (object instanceof CEO){
            ((CEO)object).printC();
        }
        System.out.println(object.getClass().getSimpleName());
//        list=new ArrayList<CEO>();
    }
}
 
class Manager extends Employee {
    public void printM(){
        System.out.println("Manager");
    }
}
 
class Employee {
    public static void printE(){
        System.out.println("Employee");
    }
}