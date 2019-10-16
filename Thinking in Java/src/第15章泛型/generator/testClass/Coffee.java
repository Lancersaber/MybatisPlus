package 第15章泛型.generator.testClass;

public class Coffee {
    private static long counter=0;
    private final long id=counter++;

    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }
}
