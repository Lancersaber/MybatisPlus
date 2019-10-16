package chapter1.demo4;

public class Main {

    public static void main(String[] args){
        System.out.println("Testing EaterThread!");
        Tool spoon=new Tool("Spoon");
        Tool fork=new Tool("fork");
        Pair pair=new Pair(spoon,fork);
        new EaterThread("Alice",pair).start();
        new EaterThread("Bobby",pair).start();
    }
}
