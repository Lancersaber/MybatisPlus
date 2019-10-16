//: net/mindview/util/CollectionData.java
// A Collection filled with data using a generator object.
package 第15章泛型.generatorTest;

import net.mindview.util.Generator;

import java.util.ArrayList;

//CollectionData 实际上是一个Collection
public class CollectionData<T> extends ArrayList<T> {
  public CollectionData(Generator<T> gen, int quantity) {
    for(int i = 0; i < quantity; i++)
      add(gen.next());
  }
  // A generic convenience method:
  public static <T> CollectionData<T>
  list(Generator<T> gen, int quantity) {
    return new CollectionData<T>(gen, quantity);
  }
} ///:~
