package com.lancer.card1.Shallow_Deep_Copy;

public class Student implements Cloneable{

    private String name;

    public Student(String name){
        this.name=name;
    }

    public Student(){

    }

    public String toString(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student stu=null;
        stu= (Student) super.clone();
        return stu;
    }
}
