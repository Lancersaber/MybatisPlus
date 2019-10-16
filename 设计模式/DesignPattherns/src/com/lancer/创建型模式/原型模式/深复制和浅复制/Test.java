package com.lancer.创建型模式.原型模式.深复制和浅复制;

import java.util.ArrayList;

public class Test implements Cloneable {

    //私有属性
    private ArrayList<String> nameList=new ArrayList<>();

    //添加内容
    public void add(String s){
        this.nameList.add(s);
    }

    //获得ArrayList对象
    public ArrayList<String> get(){
        return this.nameList;
    }

    //clone方法
    @Override
    public Test clone(){
        try {
            //浅复制
//            return (Test)super.clone();

            //深拷贝
            Test test= (Test) super.clone();
            //将类中的线性表也进行了拷贝
            test.nameList=(ArrayList<String>)this.nameList.clone();
            return test;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]){
        //创建test对象
        Test test=new Test();
        //设置test对象内容
        test.add("aa");
        test.add("bb");

        //打印显示test中的nameList内容
        System.out.println("test:"+test.get());

        //克隆test对象生成的对象
        Test test1=test.clone();

        //添加cc内容到test1对象中
        test1.add("cc");
        System.out.println("test1:"+test1.get()) ;

        System.out.println("test:"+test.get());

        /**
         *      由输出结果可以看到，添加到test1对象中内容，同样地被添加到test对象中，对克隆对象的修改，会影响到原始对象中的内容！
         * 这就是浅复制带来的结果。
         * 1）浅复制
         *      Object类的clone方法只是复制本对象的原始数据类型，如int，float，String等，对于数组和对象引用等是不会复制的。因此
         *  浅复制是有风险的。
         */
    }
}
