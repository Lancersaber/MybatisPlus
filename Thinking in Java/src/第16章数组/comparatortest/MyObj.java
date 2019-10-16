package 第16章数组.comparatortest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MyObj implements Comparable<MyObj> {

    private int id;
    private int age;

    @Override
    public int compareTo(MyObj o) {
        return (this.id-o.getId()<0)?-1:(this.id==o.getId()?0:1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyObj(int id, int age){
        this.id=id;
        this.age=age;
    }

    @Override
    public String toString() {
        return "MyObj{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args){
        MyObj[] objs=new MyObj[10];
        for (int i=0;i<objs.length;i++){
            objs[i]=new MyObj((int)(Math.random()*100),(int)(Math.random()*100));
        }
        System.out.println(Arrays.toString(objs));
        Arrays.sort(objs,new MyComparator());
//        System.out.println(Arrays.toString(objs));
        //Collections.reverseOrder()：产生一个Comparator,它可以反转自然的排序顺序。
        Arrays.sort(objs, Collections.reverseOrder());
//        System.out.println(Arrays.toString(objs));
        int [] array={32,1,23,45,65,0};

    }
    //由实验的结果可知，传入的Comparator优先级大于自身的compareTo函数
}

//要比较什么类型，类型参数这里就填什么类型
class MyComparator implements Comparator<MyObj>{

    @Override
    public int compare(MyObj o1, MyObj o2) {
        return (o1.getAge()-o2.getAge()<0)?-1:(o1.getAge()==o2.getAge()?0:1);
    }
}
