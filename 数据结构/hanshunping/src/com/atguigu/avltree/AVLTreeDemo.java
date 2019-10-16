package com.atguigu.avltree;

public class AVLTreeDemo {
    public static void main(String[] args){
        int[] arr={4,3,6,5,7,8};
        //用双旋转才能解决的数组示例
        int[] array={10,11,7,6,8,9};
        int[] test={4,5,6,7,1};
        //创建一个AVLTree对象
        AVLTree avlTree=new AVLTree();
        //添加结点
        for (int i=0;i<array.length;i++){
            avlTree.add(new Node(array[i]));
        }

        avlTree.infixOrder();
        //在没有做平衡处理之前
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
    }
}

//创建AVLTree
class AVLTree{
    private Node root;

    public Node getRoot(){
        return root;
    }

    //添加节点的方法
    public void add(Node node){
        if(root==null){
            root=node;
        }else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空");
        }
    }

    //查找要删除的节点
    public Node search(int value){
        if(root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     *
     * @param node 传入的节点(当作二叉排序树的根节点)
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public Node delRightTreeMin(Node node){
        Node temp=node;
        if(node==null){
            return null;
        }
        while (temp.left!=null){
            temp=temp.left;
        }
        System.out.println("temp=:"+temp);
        //删除最小节点
        delNode(temp.value);
        return temp;
    }

    //删除节点
    public void delNode(int value){
        if(root==null){
            return;
        }else {
            //1、需要先去找到要删除的节点 targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的节点
            if(targetNode==null){
                return;
            }
            //如果我们发现当前这颗二叉树只有一个根节点
            if(root.left==null&&root.right==null){
                root=null;
                return;
            }

            //去找到targetNode的父节点
            Node parentNode=searchParent(value);

            //如果要删除的节点是叶子节点
            if(targetNode.left==null&&targetNode.right==null){//目标节点是叶节点
                //判断targetNode节点是父节点的左子节点还是右子节点
                if(parentNode.left!=null&&parentNode.left.value==value){//是左zi
                    parentNode.left=null;
                }else if(parentNode.right!=null&&parentNode.right.value==value){
                    parentNode.right=null;
                }
            }else if(targetNode.left!=null&&targetNode.right!=null){//目标节点有两颗子树
                Node node = delRightTreeMin(targetNode.right);
                targetNode.value=node.value;
            }else {//删除只要一颗子树的节点
                if(targetNode.left!=null){//有左子节点
                    if(parentNode.left.value==value){//targetNode是parentNode的左子节点
                        parentNode.left=targetNode.left;
                    }else {
                        parentNode.right=targetNode.left;
                    }
                }else {//有右子节点
                    if(parentNode.left.value==value){//targetNode是parentNode的左子节点
                        parentNode.left=targetNode.right;
                    }else {
                        parentNode.right=targetNode.right;
                    }
                }
            }


        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value=value;
    }

    //返回当前结点的高度，以该结点为根结点的树的高度
    public int height(){
        return Math.max(left==null? 0: left.height(),right==null?0:right.height())+1;
    }

    //左旋转
    private void leftRotate(){
        //1、创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //2、把新的结点的左子树设置成当前结点的左子树
        newNode.left=left;
        //3、把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right=right.left;
        //4、把当前的值替换成右子结点的值
        value=right.value;
        //5、把当前结点的右子树设置成当前结点右子树的右子树
        right=right.right;
        //6、把当前结点的左子结点设置成新的结点
        left=newNode;
    }

    //右旋转
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;
    }

    //返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }else {
            return left.height();
        }
    }

    //返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }else {
            return right.height();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    //递归的形式添加节点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if(node==null){
            return;
        }

        //判断传入的节点的值，
        if(node.value<this.value){
            //如果当前节点左子节点为空
            if(this.left==null){
                this.left=node;
            }else {
                //递归地向左子树添加
                this.left.add(node);
            }
        }else {//添加的节点的值大于当前节点的值
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
        //当添加完一个结点后，如果(右子树的高度-左子树的高度)>1,左旋转
        if (rightHeight()-leftHeight()>1){
            //如果它的右子树的左子树的高度大于它的右子树的高度
            if (right!=null &&right.leftHeight()>right.rightHeight()){
                //先对当前结点的右结点进行右旋转
                right.rightRotate();
                leftRotate();//左旋转
            }else {
                leftRotate();
            }
            return;
        }
        if (leftHeight()-rightHeight()>1){
            //如果它的左子树的右子树的高度大于它的左子树的高度
            if (left!=null &&left.rightHeight()>left.leftHeight()){
                //先对当前结点的左结点进行左旋转
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();//右旋转
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    //查找要删除的节点
    /**
     *
     * @param value:希望删除节点的值
     * @return 如果找到返回该节点，否则返回null
     */
    public Node search(int value){
//        Node node=null;
        if(value==this.value){//说明找到，就是该节点
            return this;
        }else if(value<this.value){//如果查找的值小于当前节点的值，向左子树递归查找
            if(this.left!=null){
                return this.left.search(value);
            }
        }else {
            if(this.right!=null){
                return this.right.search(value);
            }
        }
        return null;
    }

    //查找要删除节点的父节点方法
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if(value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }
            else {
                return null;//没有找到父节点
            }
        }
    }



}