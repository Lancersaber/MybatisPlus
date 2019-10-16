package 第14章类型信息;//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

import static net.mindview.util.Print.print;

class Candy {
  static { print("Loading Candy"); }
  static {print("hello world");}
}

class Gum {
  static { print("Loading Gum"); }
}

class Cookie {
  static { print("Loading Cookie"); }
}

public class SweetShop {
  public static void main(String[] args) {	
    print("inside main");
    new Candy();
    print("After creating Candy");
    try {
      Class<?> gum = Class.forName("第14章类型信息.Gum");
      System.out.println(gum.getSimpleName());
    } catch(ClassNotFoundException e) {
      print("Couldn't find Gum");
    }
    print("After Class.forName(\"Gum\")");
    new Cookie();
    print("After creating Cookie");
  }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
