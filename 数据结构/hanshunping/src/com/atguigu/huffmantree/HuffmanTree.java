package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  赫夫曼树
 *  给定n个权值作为n个子叶节点，构造一棵二叉树，若该树的带权路径长度(wpl)达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree)
 */

/**
 * 构成赫夫曼树的步骤
 * 1、从小到大进行排序，将每一个数据，每个数据都是一个节点，每个节点可以看成是一颗最简单的二叉树
 * 2、取出根节点权值最小的两颗二叉树
 * 3、组成一颗新的二叉树，该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
 * 4、再将这棵新的二叉树，以根节点的权值大小再次排序，不断重复1-2-3-4的步骤，直到数列中，所有的数据都被处理，就得到一棵赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args){
        int arr[]={13,7,8,3,29,6,1};
        MyNode huffmanTree = createHuffmanTree(arr);
        huffmanTree.preOrder();
    }

    //创建赫夫曼树的方法
    public static MyNode createHuffmanTree(int[] arr){
        //第一步为了操作方便
        //1、遍历arr数组
        //2、将arr的每个元素构建成一个Node
        //3、将Node放入到ArrayList中
        ArrayList<MyNode> nodes=new ArrayList<>();
        for (int value:arr){
            nodes.add(new MyNode(value));
        }

        while (nodes.size()>1){
            //排序 从小到大
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //1)、取出权值最小的二叉树节点
            MyNode leftNode=nodes.get(0);
            //2)、取出权值第二小的节点
            MyNode rightNode=nodes.get(1);

            //3)、构建一棵新的二叉树
            MyNode parent=new MyNode(leftNode.value+rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;

            //4)、从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //5)、将parent加入到nodes
            nodes.add(parent);
        }

        //返回赫夫曼的root节点
        return nodes.get(0);
    }

    //编写一个前序遍历的方法
    public static void preOrder(MyNode root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("该树是空树");
        }
    }
}

//创建节点
//为了让Node 对象支持排序Collection集合排序
//让Node 实现Comparable接口
class MyNode implements Comparable<MyNode>{
    int value;  //节点权值
    MyNode left;  //指向左子节点
    MyNode right; //指向右子节点

    public MyNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(MyNode o) {
        //表示从小到大排序
        return this.value-o.value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    /**
     * 霍夫曼编码的原理
     * 1）待传输的字符串==>I like like like java do you like a java
     * 2）统计各个字符对应的个数 d:1 y:1 u:1 j:2 v:2 o:2 l:4 k:4 e:4 i:5 a:5  :9 //各个字符对应的个数
     * 3）按照上面字符出现的次数构建成一棵霍夫曼树，次数作为权值
     * 4）根据路径给各个字符规定编码，向左的路径为0，向右的路径为1
     */
}
