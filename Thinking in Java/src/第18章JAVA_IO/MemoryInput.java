package 第18章JAVA_IO;//: io/MemoryInput.java

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
  public static void main(String[] args)
  throws IOException {
    StringReader in = new StringReader(
      BufferedInputFile.read("D:\\IOTest\\1.txt"));
    int c;
    while((c = in.read()) != -1)
      System.out.print((char)c);
  }
} /* (Execute to see output) *///:~
