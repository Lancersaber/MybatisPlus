package 第17章深入容器;//: containers/Groundhog.java
// Looks plausible, but doesn't work as a HashMap key.

public class Groundhog {
  protected int number;
  public Groundhog(int n) { number = n; }
//  public String toString() {
//    return "Groundhog #" + number;
//  }

  public static void main(String[] args){
    Groundhog groundhog = new Groundhog(1);
    System.out.println(groundhog.hashCode());
    System.out.println(groundhog);
  }
} ///:~
