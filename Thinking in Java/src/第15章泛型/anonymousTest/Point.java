package 第15章泛型.anonymousTest;

import java.util.ArrayList;
import java.util.List;

public class Point<T> {
    private T x;      
    private T y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(){
        
    }
    public Point(T x,T y){
        this.x = x;
        this.y = y;
    }
 
    public void setX(T x) {
        this.x = x;
    }
 
    public void setY(T y) {
        this.y = y;
    }
 
    public T getX() {
        return this.x;
    }
 
    public T getY() {
        return this.y;
    }

    public static void main(String[] args){
        Point<?> point;

        point = new Point<Integer>(3,3);
        point = new Point<Float>(4.3f,4.3f);
        point = new Point<Double>(4.3d,4.90d);
        point = new Point<Long>(12l,23l);

//        ArrayList<String> [] ls=new ArrayList<String>()[10];
       /* ArrayList<Integer>[] lists=new ArrayList[10];

        int index;
        int num;
        for (int j=0;j<100;j++){
            num=(int)(Math.random()*10000);
            index=num%10;
            if (lists[index]==null){
                lists[index]=new ArrayList<>();
            }
            lists[index].add(num);
        }
        for (int j=0;j<10;j++){
            System.out.println("==>"+(j+1)+"条");
            System.out.println(lists[j]);
        }*/
//        System.out.println(i.hashCode());

        ArrayList<Point<Integer>>[] lists=new ArrayList[10];

        int index;
        int num;
        Point<Integer> point1;
        for (int j=0;j<100;j++){
            num=(int)(Math.random()*10000);
            index=num%10;
            point1=new Point<>(num,num);
            if (lists[index]==null){
                lists[index]=new ArrayList<>();
            }
            lists[index].add(point1);
        }
        for (int j=0;j<10;j++){
            System.out.println("==>"+(j+1)+"条");
            System.out.println(lists[j]);
        }
    }
}