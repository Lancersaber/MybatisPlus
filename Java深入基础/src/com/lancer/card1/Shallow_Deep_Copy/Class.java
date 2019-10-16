package com.lancer.card1.Shallow_Deep_Copy;

import java.util.Objects;

public class Class {
    private int num;

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Class{" +
                "num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return num == aClass.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public Class() {
    }

    public Class(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
