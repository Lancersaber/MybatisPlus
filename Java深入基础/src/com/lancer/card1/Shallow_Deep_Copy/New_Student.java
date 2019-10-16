package com.lancer.card1.Shallow_Deep_Copy;

public class New_Student {
    private String name;
    private Class aClass;

    public New_Student(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "New_Student{" +
                "name='" + name + '\'' +
                ", aClass=" + aClass +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public New_Student() {
    }
}
