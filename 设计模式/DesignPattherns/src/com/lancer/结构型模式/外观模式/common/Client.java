package com.lancer.结构型模式.外观模式.common;

public class Client {

    public static void main(String args[]){
        System.out.println("======开始做糖酥排骨...");
        ISpareribs spareribs=new Spareribs();
        spareribs.prepair();
        spareribs.preserve();
        spareribs.fry();
        spareribs.juice();
        System.out.println("=====糖酥排骨做好了");
    }
}
