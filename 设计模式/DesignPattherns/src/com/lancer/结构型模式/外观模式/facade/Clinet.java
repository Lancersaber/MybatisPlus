package com.lancer.结构型模式.外观模式.facade;

public class Clinet {

    public static void main(String args[]){
        System.out.println("=======开始做糖醋排骨...");
        ICookFacade cookFacade=new CookFacade();
        cookFacade.cookSpareribs();
        System.out.println("========排骨做完了...");
    }
    /**
     * 我们用外观模式实现了糖醋排骨的制作！我们不用了解排骨的制作工序，就能吃到美味了。
     */
}
