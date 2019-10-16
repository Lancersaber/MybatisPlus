//: net/mindview/util/Pair.java
package 第15章泛型.generatorTest;

public class Pair<K,V> {
  public final K key;
  public final V value;
  public Pair(K k, V v) {
    key = k;
    value = v;
  }
} ///:~
