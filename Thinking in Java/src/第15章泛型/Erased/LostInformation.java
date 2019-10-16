package 第15章泛型.Erased;

import java.util.*;

public class LostInformation {

    public static void main(String[] args){
        List<Frob> list=new ArrayList<>();
        Map<Frob,Fnorkle> map=new HashMap<>();
        Quark<Fnorkle> quark=new Quark<>();
        Particle<Long,Double> p=new Particle<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
        /**
         *      Class.getTypeParameters()将返回一个TypeVariable对象数组，表示有泛型声明的类型参数。这好像暗示你可能发现参数类型
         * 的信息，但是，正如你从输出中所看到的，你能够发现的只是用做参数占位符的标识符，这并非有用的信息
         *
         * 因此，残酷的现实是：在泛型代码内部，无法获得任何有关泛型参数类型的任何信息
         *
         *
         */
    }
}

class Frob{

}

class Fnorkle{

}

class Quark<Q>{

}

class Particle<POSITION,MOMENTUM>{

}
