package com.lancer.结构型模式.组合模式.common;

public class ClientOfCommon {

    public static void main(String args[]){

        //公司CEO
        Manager boss=new Manager("1","大老板","ceo",10000);

        //CEO手下有若干部门经理

        //财务部经理
        Manager financeManager=new Manager("11","张总","财务部经理",6000);



    }
}
