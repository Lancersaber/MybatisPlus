package com.lancer.card1.Shallow_Deep_Copy;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student("Mike");
        Student student1=student;

        //很明显 student 与 student1 两个引用指向了
        System.out.println(student1==student);

        Student student2=student.clone();
        System.out.println(student2==student);
        student.setName("Jack");
        System.out.println(student.getName());
        System.out.println(student2.getName());


        Class class1=new Class(1);
        New_Student new_student=new New_Student("Mike",class1);

    }
}
