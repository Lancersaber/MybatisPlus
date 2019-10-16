//: typeinfo/pets/Cat.java
package 第14章类型信息.pets;

import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cat extends Pet {
  public Cat(String name) { super(name); }
  public Cat() { super(); }

  public static void main(String[] args){
    ArrayList<Class<? extends A>> list= new ArrayList<>(Arrays.asList(A.class,B.class,C.class));
    A aa=new A();
    B bb=new B();
    C cc=new C();
    int a=0,b=0,c=0;
    /*for (int i=0;i<10;i++){
      if (list.get(i%list.size()).isInstance(aa)){
        a++;
      }
      if (list.get(i%list.size()).isInstance(bb)){
        b++;
      }
      if (list.get(i%list.size()).isInstance(cc)){
        c++;
      }
    }*/
    for(int i=0;i<10;i++){
      if (list.get(i%list.size())==A.class){
        a++;
      }if (list.get(i%list.size())==B.class){
        b++;
      }if (list.get(i%list.size())==C.class){
        c++;
      }
    }
    System.out.println("a="+a+" b="+b+" c="+c);
    Class test;
    test=aa.getClass();
    test=bb.getClass();
  }
} ///:~

class A{

}

class B extends A{

}

class C extends A{

}