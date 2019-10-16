package 第16章数组.DataGenerator;

import 第15章泛型.generator.Generator;

public class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean>{

        private boolean value=false;
        @Override
        public java.lang.Boolean next() {
            value=!value;// Just flips back and forth 只是来回翻转
            return value;
        }
    }

}
