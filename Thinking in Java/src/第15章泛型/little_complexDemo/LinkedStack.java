package 第15章泛型.little_complexDemo;

public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            item=null;
            next=null;
        }
        Node(U item,Node<U> next){
            this.item=item;
            this.next=next;
        }
        boolean end(){
            return item==null&&next==null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> top=new Node<>();//End sentinel(哨兵)

    public void push(T item){
        top=new Node<T>(item,top);
        System.out.println("top="+top);
    }

    public T pop(){
        T result=top.item;
        if (!top.end())
            top=top.next;
        return result;
    }

    public static void main(String[] args){
        LinkedStack<String> lss=new LinkedStack<>();
        for (String s:"Phasers on stun".split(" ")){
            lss.push(s);
        }
        String s;
        while ((s=lss.pop())!=null){
            System.out.println(s);
        }
    }
}
