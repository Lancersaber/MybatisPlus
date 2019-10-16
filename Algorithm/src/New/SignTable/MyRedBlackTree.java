package New.SignTable;

//第一次写红黑树
public class MyRedBlackTree<Key extends Comparable<Key>,Value> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private Node root;

    private class Node{
        Key key; //键
        Value val; //值
        Node left,right; //左右子树
        int N; //这棵子树的结点总数
        boolean color; //由其父节点指向它的链接颜色

        Node(Key key,Value val,int N,boolean color){
            this.key=key;
            this.val=val;
            this.N=N;
            this.color=color;
        }
    }

    private boolean isRed(Node x){ //判断一个结点是否为红结点
        if (x==null)
            return false;
        return x.color==RED;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x){
        if (x==null) return 0;
        else return x.N;
    }

    //左旋转
    Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color= RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }

    //右旋转
    Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }

    private void flipColors(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    public void put(Key key,Value val){
        //查找key，找到则更新其值，否则为它新建一个结点
        root=put(root,key,val);
        root.color=BLACK;
    }

    private Node put(Node h,Key key,Value val){
        if (h==null) return new Node(key,val,1,RED); //标准的插入操作，和父节点用红链接相连
        int cmp=key.compareTo(h.key);
        if (cmp<0) h.left=put(h.left,key,val);
        else if (cmp>0) h.right=put(h.right,key,val);
        else h.val=val;

        if (isRed(h.right) && !isRed(h.left)) h=rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h=rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N=size(h.left)+size(h.right)+1;
        return h;
    }

    public boolean isEmpty(){
        return size(root)==0;
    }

    //删除最小键,实现红黑树的deleteMin()方法，在沿着树的最左路径向下的过程中实现正文所述的变换，保证当前结点不是 2-结点
    private Node moveRedLeft(Node h){
        //假设结点h 为红色，h.left 和 h.left.left 都是黑色
        //将h.left 或者 h.left的子结点之一变红
        return null;
    }
}
