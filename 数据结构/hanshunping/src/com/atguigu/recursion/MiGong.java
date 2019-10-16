package com.atguigu.recursion;

import java.util.Arrays;

/**
 * 递归需要遵守的重要规则
 * 1、执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
 * 2、方法的局部变量是独立的，不会相互影响，比如n变量
 * 3、如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型。
 * 4、递归必须向退出的条件逼近，否则就是无限递归
 * 5、当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行
 * 完毕或者返回时，该方法也就执行完毕了。
 */
public class MiGong {

    public static void main(String[] args){
        //先创建一个二维数组模拟迷宫
        int width=8;//宽度
        int high=7;//长度
        int[][] map=new int[width][high];
        printDeepArray(map);
        //使用1 表示墙
        //先把上下全部置为1
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        map[2][2]=1;
        printDeepArray(map);
        setWay(map,1,1);
        printDeepArray(map);
    }

    public static void printDeepArray(int[][] map){
        System.out.println("======================");
        for (int[] array:map){
            for (int i:array){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路

    /**
     *
     * @param map   表示地图
     * @param i     从哪个位置开始找
     * @param j
     * @return  如果找到通路就返回true，否则就返回false
     */
    //说明：
    //1、map表示地图
    //2、i,j 表示从地图的哪个位置开始出发(1,1)
    //3、如果小球能到达map[6,5]则说明通路找到
    //4、约定：当map[i][j]为0表示该点没有走过,当为1时表示墙，2 表示通路可以走，3 表示该点已经走过，但是走不通
    //5、在走迷宫时需要确定一个策略（方法） 下->右->上->左，如果该点走不通，再回溯
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){ //通路已经找到
            return true;
        }else {
            if (map[i][j]==0){  //如果当前这个点还没有走过
                //按照策略 下->右->上->左
                map[i][j]=2; //假定这个点可以走通
                if (setWay(map,i+1,j)){ //向下走
                    return true;
                }else if (setWay(map,i,j+1)){//向右走
                    return true;
                }else if (setWay(map,i-1,j)){//向上走
                    return true;
                }else if (setWay(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点是走不通的，是死路
                    map[i][j]=3;
                    return false;
                }
            }else { //如果map[i][j]!=0,可能是1，2，3
                return false;
            }
        }
    }

}
