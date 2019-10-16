package com.lancer.结构型模式.外观模式.common;

public class Spareribs implements ISpareribs {
    @Override
    public void prepair() {
        System.out.println("1、准备🐖排骨500克，葱、姜、白糖等适量...");
    }

    @Override
    public void preserve() {
        System.out.println("2、将🐖排骨洗干净剁成3厘米长段，加入盐...");
    }

    @Override
    public void fry() {
        System.out.println("3、油炸...");
    }

    @Override
    public void juice() {
        System.out.println("4、捞出...");
    }
}
