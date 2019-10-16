package chapter1.demo3;

public class Main {

    public static void main(String[] args){
        System.out.println("Testing EaterThread!");
        Tool spoon=new Tool("Spoon");
        Tool fork=new Tool("fork");
        new EaterThread("Alice",spoon,fork).start();
        new EaterThread("Bobby",fork,spoon).start();
    }
}
