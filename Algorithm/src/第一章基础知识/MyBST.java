package 第一章基础知识;

public class MyBST<Key extends Comparable<Key>, Value> {

    public static void main(String[] args){
        MyBST<Integer,String> bst=new MyBST<>();
        bst.put(2,"宋江");
        bst.put(1,"吴用");
        bst.put(3,"孙悟空");
        bst.put(-1,"公孙胜");
        bst.put(66,"李逵");
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

    public MyBST(){}

    //根据key值取出对应的Value
    public Value get(Key key){
        if (key==null) throw new IllegalArgumentException("The key can't be null");
        Node x=root;
        while (x!=null){
            int cmp=key.compareTo(x.key);
            if (cmp<0) x=x.left;
            else if (cmp>0) x=x.right;
            else return x.val;
        }
        return null;
    }

    public void put(Key key,Value value){
        if (key==null) throw new IllegalArgumentException("The key can't be null");
        if (value==null){
            delete(key);
            return;
        }
        if (root==null){
            root=new Node(key,value,1);
            return;
        }
        Node x=root;
        Node pre=x;
        while (x!=null){
            pre=x;
            int cmp=key.compareTo(x.key);
            if (cmp<0) x=x.left;
            else if (cmp>0) x=x.right;
            else break;
        }
        if (x==null){
            if (key.compareTo(pre.key)<0){
                pre.left=new Node(key,value,1);
            }else {
                pre.right=new Node(key,value,1);
            }
        }else {
            x.val=value;
        }
    }

    public void delete(Key key){

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
