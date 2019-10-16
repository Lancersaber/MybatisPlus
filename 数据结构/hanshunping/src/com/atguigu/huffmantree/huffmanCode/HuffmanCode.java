package com.atguigu.huffmantree.huffmanCode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args){
        String str="i like like like java do you like a java";
        byte[] strBytes = str.getBytes();
        System.out.println(strBytes.length);
        ArrayList<Node> nodes = getNodes(strBytes);
//        System.out.println(nodes);
        System.out.println("霍夫曼树");
        Node huffmanTree = createHuffmanTree(nodes);
//        huffmanTree.preOrder();

        //测试一下是否生成了对应的霍夫曼编码
//        getCodes(huffmanTree,"",stringBuilder);
        getCodes(huffmanTree);
//        System.out.println("生成的霍夫曼编码表"+huffmanCodes);
        byte[] zip = zip(strBytes, huffmanCodes);
        System.out.println("霍夫曼编码后的bytes");
        System.out.println(Arrays.toString(zip));
    }

    private static ArrayList<Node> getNodes(byte[] bytes){
        //1、创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes，统计 每一个byte出现的次数-->map
        Map<Byte,Integer> counts=new HashMap<>();
        for (byte b:bytes){
            Integer count=counts.get(b);
            if (count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        //把每一个键值对转换成一个Node对象，并加入到nodes集合
        //遍历Map
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }

    //通过List 创建对应的霍夫曼树
    private static Node createHuffmanTree(ArrayList<Node> nodes){
        while (nodes.size()>1){
            //排序,从小到大
            Collections.sort(nodes);
            //取出第一棵最小的二叉树
            Node leftnode = nodes.get(0);
            Node rightNode=nodes.get(1);
            //创建一棵新的二叉树,它的根节点没有data，只有权值，所有的字符都放在叶子节点
            Node parent=new Node(null,leftnode.weight+rightNode.weight);
            parent.left=leftnode;
            parent.right=rightNode;

            //将处理过的两颗二叉树移除
            nodes.remove(leftnode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes中
            nodes.add(parent);
        }
        //nodes最后的节点就是霍夫曼树的根节点
        return nodes.get(0);
    }

    //前序遍历的方法
    private static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("该树为空");
        }
    }

    //生成霍夫曼树对应的霍夫曼编码
    //思路
    //1、将霍夫曼编码表放在Map<Byte,String>
    //2、生成霍夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
    static Map<Byte,String> huffmanCodes=new HashMap<>();
    static StringBuilder stringBuilder=new StringBuilder();

    /**
     * 功能：将传入的node节点的所有叶子节点的霍夫曼编码得到，并放入到huffmanCodes集合
     * @param node  传入节点，
     * @param code  路径：左子节点是0，右子节点是1
     * @param stringBuilder 是用于拼接路径的
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringbuilder2
        stringBuilder2.append(code);
        if (node!=null){    //如果node==null 不处理
            //判断当前node 是叶子节点还是非叶子节点
            if (node.data==null){   //非叶子节点
                //递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else {//说明是一个叶子节点，就表示找到某个叶子节点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    private static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        //处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        //处理root的右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    //编写一个方法，将字符串对应的byte[] 数组，通过生成的霍夫曼编码表，返回一个霍夫曼编码 压缩后的byte[]

    /**
     *
     * @param bytes 原始的字符串对应的byte[]
     * @param huffmanCodes  生成的霍夫曼编码Map
     * @return  返回霍夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1、利用huffmanCodes 将bytes 转成 霍夫曼编码对应的字符串
        StringBuilder stringBuilder=new StringBuilder();
        //遍历bytes 数组
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder);

        //将stringBuilder转换成byte[]
        //统计返回的
        int len=0;
        if (stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes=new byte[len];
        int index=0;// 记录是第几个byte
        for (int i=0;i<stringBuilder.length();i+=8){    //因为是每8位对应一个byte，所以步长为8
            String strByte;
            //这里不能保证stringBuilder的长度是8的倍数
            if (i+8>stringBuilder.length()){
                strByte=stringBuilder.substring(i);
            }else {
                strByte=stringBuilder.substring(i,i+8);
            }

            //将strByte转成一个byte，放入到huffmanCodeBytes中
            huffmanCodeBytes[index]=(byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }
}

//创建Node，带数据和权值
class Node implements Comparable<Node>{
    Byte data; //存放数据本身，比如'a'==>97 ' '==>32
    int weight; //权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data,int weight) {
        this.data = data;
        this.weight=weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}