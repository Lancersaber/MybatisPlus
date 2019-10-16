package 第16章数组.comparable;

import 第15章泛型.generator.Generator;

import java.util.Random;

public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count=1;

    public CompType(int n1,int n2){
        i=n1;
        j=n2;
    }

    @Override
    public String toString() {
        String result= "CompType{" +
                "i=" + i +
                ", j=" + j +
                '}';
        if (count++%3==0){
            result+="\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return (i<o.i?-1:(i==o.i?0:1));
    }

    private static Random r=new Random(47);

    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100),r.nextInt(100));
            }
        };
    }

    public static void main(String[] args){

    }
}
