package 第一章基础知识;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public static void main(String[] args){
        BinarySearchTree<Integer,String> bst=new BinarySearchTree<>();
        bst.put(2,"宋江");
        bst.put(1,"吴用");
        bst.put(3,"孙悟空");
        bst.infixOrder();
    }

    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    public BinarySearchTree(){

    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node==null) return 0;
        else return node.size;
    }

    public boolean contains(Key key){
        if (key==null)  throw new IllegalArgumentException("The key can't be null");
        return get(key)!=null;
    }


    public Value get(Key key){
        return get(root,key);
    }

    //在以 x 为根节点的树下查找 键值为 key 的 value值
    private Value get(Node x, Key key){
        if (key==null) throw new IllegalArgumentException("The key can't be null");
        if (x==null) return null;
        int cmp=x.key.compareTo(key);
        if (cmp<0) //说明 key 值在 x 的右边
            return get(x.right,key);
        else if (cmp>0) //说明 key 值在 x 的左边
           return get(x.left, key);
        else return x.val;
    }

    public void put(Key key,Value value){
        if (key==null) throw new IllegalArgumentException("The key can't be null");
        root=put(root,key,value);
    }

    //妙
    private Node put(Node x,Key key,Value value){
        if (x==null)
           return new Node(key,value,1);
        int cmp=key.compareTo(x.key);
        if (cmp<0) x.left=put(x.left,key,value);
        else if (cmp>0) x.right=put(x.right,key,value);
        else x.val=value;
        x.size=size(x.left)+size(x.right)+1;
        return x;
    }

    public void infixOrder(){
        infixOrder(root);
    }

    private void infixOrder(Node x){
        if (x==null)
            return;
        infixOrder(x.left);
        System.out.println(x);
        infixOrder(x.right);
    }
}
