package com.lancer.结构型模式.享元模式.flyweight.object2;

import java.util.Hashtable;

public class FiveChessmanFactory {
    //单例模式工厂
    private static FiveChessmanFactory fiveChessmanFactory=new FiveChessmanFactory();

    //缓存存放共享对象
    private final Hashtable<Character, AbstractChessman> cache=new Hashtable<>();

    private FiveChessmanFactory(){

    }

    public static FiveChessmanFactory getInstance(){
        return fiveChessmanFactory;
    }

    public AbstractChessman getChessmanObject(char c){
        //从缓存中获得对象实例
        AbstractChessman abstractChessman=this.cache.get(c);

        if(abstractChessman==null){
            //缓存中没有棋子对象实例信息，则创建棋子对象实例，并放入缓存
            switch (c){
                case 'B':
                    abstractChessman=new BlackChessman();
                    break;
                case 'W':
                    abstractChessman=new WhiteChessman();
                    break;
                    default:

            }
            //为防止非法字符的进入，返回null
            if(abstractChessman!=null){
                this.cache.put(c,abstractChessman);
            }
        }
        return abstractChessman;
    }
}
