package 第15章泛型.generatorTest;//: generics/BasicGeneratorDemo.java
import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;
import 第15章泛型.generator.generic_generator.CountedObject;

public class BasicGeneratorDemo {
  public static void main(String[] args) {
    Generator<CountedObject> gen =
      BasicGenerator.create(CountedObject.class);
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
  }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
