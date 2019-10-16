package com.lancer.结构型模式.享元模式;

import com.lancer.结构型模式.享元模式.flyweight.object2.FiveChessmanFactory;
import com.lancer.结构型模式.享元模式.flyweight.object2.AbstractChessman;

import java.util.Random;

public class Client {

    public static void main(String args[]){

        //创建五子棋工厂
        FiveChessmanFactory fiveChessmanFactory=FiveChessmanFactory.getInstance();

        //随机数，用来随机生成棋子对象
        Random random=new Random();

        int radom=0;

        AbstractChessman abstractChessman=null;
        //随机获得棋子
        for(int i=0;i<10;i++){
            radom=random.nextInt(2);
            switch (radom){
                case 0:
                    abstractChessman=fiveChessmanFactory.getChessmanObject('B');
                    break;
                case 1:
                    abstractChessman=fiveChessmanFactory.getChessmanObject('W');
                    break;
            }
            if(abstractChessman!=null){
                abstractChessman.paint(i,random.nextInt(15));
            }
        }

    }
    /**
     *      从输出结果来看，享元对象已经生效了，共享了元对象，节省了内存空间。然而，我们现在只做到了共享棋子实例，还有一点不要
     * 忘记，就是棋子的位置！虽然棋子对象是可以共享的，但是每一个棋子的位置都是不一样的，是不能共享的。这就是享元模式的两种状态：
     * 内蕴状态(Internal State)和外蕴状态(External State)
     *
     * 1、内蕴状态(Internal State)
     *      享元对象的内蕴状态(Internal State)是不会随环境的改变而改变的，是存储在享元对象内部的状态信息，因此内蕴对象是可以共享的，对于
     *  任何一个享元对象来说，它的值是完全相同的。
     *
     *  2、外蕴对象(External State)
     *      享元对象的第二状态称为外蕴状态(External State),它是会随环境的变化而改变的，因此是不可以共享的状态，对于不同的享元对象来说，
     * 它的值可能是不同的。享元对象的外蕴状态必须由客户端保存，在享元对象被创建之后，需要使用的时候在传入到享元对象内部。
     *
     *      所以，享元的外蕴状态与内蕴状态是两类相互独立的状态，彼此没有关联。
     */
}
