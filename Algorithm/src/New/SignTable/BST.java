package New.SignTable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>,Value>{

    public static void main(String[] args){
        BST<Integer,String> bst=new BST<>();
        bst.put(34,"安徽");
        bst.put(12,"合肥");
        bst.put(88,"武汉");
        bst.infixOrder();
        String s=bst.get(34);
        System.out.println(s);
        System.out.println("The size is "+bst.size());

        Integer min = bst.min();
        System.out.println("最小的键值是 "+min);

        Integer max = bst.max();
        System.out.println("最大的键值是 "+max);

        Integer floor = bst.floor(13);
        System.out.println("The floor(13) is "+floor);

        Integer ceiling = bst.ceiling(13);
        System.out.println("The ceiling(13) is "+ceiling);

        int rank = bst.rank(13);
        System.out.println("rank(13) = "+rank);

        Integer select = bst.select(1);
        System.out.println("bst.select(1) = "+select);

        System.out.println("====================");
        bst.deleteMax();
        bst.infixOrder();
//        bst.delete(34);
//        bst.infixOrder();

        System.out.println("==========================");
        Iterable<Integer> keys = bst.keys();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private Node root; //二叉查找树的根结点

    private class Node{
        private Key key; //键
        private Value val; //值
        private Node left,right;//指向子树的链接
        private int N; //以该结点为根的子树中的结点总数

        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    public void put(Key key, Value val) {
        root=put(root,key,val);
    }

    //说明：如果key存在于以x为根结点的子树中则更新它的值；
    //否则将以key和val为键值对的新的结点插入到该子树中
    private Node put(Node x,Key key,Value val){
        if (x==null) return new Node(key,val,1);
        //如果x不为null，找出key应该插入的位置
        int cmp=key.compareTo(x.key);
        //同样三种情况
        if (cmp<0){  //key 小于当前键值===> go left
            x.left=put(x.left,key,val);//如果x.left == null ，正好返回一个new出来的结点
        }else if (cmp>0){ //key 大于当前键值===> go right
            x.right=put(x.right,key,val);
        }else {
            x.val=val;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public Value get(Key key) {
        return get(root,key);
    }

    //说明：在以 x 为根结点的子树中查找并返回key所对应的值，如果找不到返回null
    private Value get(Node x,Key key){
        if (x==null) return null;
        int cmp=key.compareTo(x.key); //将给定的键值与当前结点进行比较
        //其实比较的结果就三种情况
        if (cmp<0){ //key 小于当前键值===> go left
            return get(x.left,key);
        }
        else if (cmp>0){//key 小于当前键值===> go right
            return get(x.right,key);
        }
        else return x.val;//正好匹配
    }

    public void delete(Key key) {
       root= delete(root,key);
    }

    private Node delete(Node x,Key key){
        if (x==null) return null;
        int cmp=key.compareTo(x.key);
        if (cmp<0) x.left=delete(x.left,key);
        else if (cmp>0) x.right=delete(x.right,key);
        else {
            if (x.right==null) return x.left;
            if (x.left==null) return x.right;

            //如果上面的两个if都没有生效，说明 x 含有左结点和右结点
            Node t=x;
            x=min(t.right);//将x 置为 x 的右子树的最小值
            x.right=deleteMin(t.right);//deleteMin(t.right)返回就是t.right
            x.left=t.left;
        }

        x.N=size(x.left)+size(x.right)+1;
        return x;
    }


    public boolean contains(Key key) {
        return get(key)!=null;
    }


    public boolean isEmpty() {
        return size()==0;
    }


    public int size() {
        return size(root);
    }

    private int size(Node x){
        if (x==null) return 0;
        else return x.N;
    }


    public Iterable<Key> keys() {
        return key(min(),max());
    }

    public Iterable<Key> key(Key lo,Key hi){
        Queue<Key> queue=new LinkedList<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue,Key lo,Key hi){
        if (x==null) return;
        int cmplo=lo.compareTo(x.key);
        int cmphi=hi.compareTo(x.key);
        if (cmplo<0) keys(x.left,queue,lo,hi);
        if (cmplo<=0 && cmphi>=0) queue.add(x.key);
        if (cmphi>0) keys(x.right,queue,lo,hi);
    }


    public Key min() {
        return min(root).key;
    }

    //以给定 x 为根结点找出最小键值
    private Node min(Node x){
        if (x.left==null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node x){
        if (x.right==null) return x.key;
        return max(x.right);
    }



    public Key floor(Key key) {
        Node t=floor(root,key);
        if (t==null) return null;
        return t.key;
    }

    private Node floor(Node x,Key key){
        if (x==null) return null;//退出循环的条件
        int cmp=key.compareTo(x.key);
        if (cmp==0) return x;
        if (cmp<0) return floor(x.left,key);
        //当cmp>0时，情况就不一样了
        Node t=floor(x.right,key);
        if (t!=null) return t;
        else return x;
    }


    public Key ceiling(Key key) {
        Node x=ceiling(root,key);
        if (x==null) return null;
        return x.key;
    }

    private Node ceiling(Node x,Key key){ //待研究
        if (x==null) return null;
        else {
            int cmp=key.compareTo(x.key);
            if (cmp==0) return x;
            else if (cmp<0){
                Node t=ceiling(x.left,key);
                return t!=null? t:x;
            }else {
                return x.right;
            }
        }
    }


    public int rank(Key key) {
        return rank(key,root);
    }

    //说明：返回以x为根结点的子树中小于x，key的键的数量
    private int rank(Key key,Node x){
        if (x==null) return 0;
        int cmp=key.compareTo(x.key);
        if (cmp<0) return rank(key,x.left);
        else if (cmp>0) return 1+size(x.left)+rank(key,x.right);
        else return size(x.left);
    }


    public Key select(int k) {
        Node select = select(k, root);
        if (select==null){
            return null;
        }
        return select.key;
    }

    // 返回排名为k的结点
    private Node select(int k,Node x){
        if (x==null) return null;
        int t=size(x.left);
        if (t>k) return select(k,x.left);
        else if (t<k) return select(k-t-1,x.right);
        else return x;
    }


    public void deleteMin() {
        root=deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left==null) return x.right;
        //最后一个x.left必定会被置为null
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }


    public void deleteMax() {
        root=deleteMax(root);
    }
    //删除以x 为根节点的最大的结点
    private Node deleteMax(Node x){
        if (x.right==null) return x.left;
        x.right=deleteMax(x.right);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }


    public int size(Comparable lo, Comparable hi) {
        return 0;
    }


    public Iterable keys(Comparable lo, Comparable hi) {
        return null;
    }

    //中序遍历整棵树
    public void infixOrder(){
        infixOrder(root);
    }

    private void infixOrder(Node x){
        //先确定递归中止的条件
        if (x==null){
            return;
        }
        infixOrder(x.left);
        System.out.println(x);
        infixOrder(x.right);
    }
}
