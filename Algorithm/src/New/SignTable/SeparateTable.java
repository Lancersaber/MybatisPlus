package New.SignTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//散列表
public class SeparateTable<Key,Value> {

    private int N;//键值对总数
    private int M;//散列表的大小
    private HashMap<Key,Value>[] st; //存放链表对象的数组

    public SeparateTable(int M){
        //创建M条链表
        this.M=M;
        st=new HashMap[M];
        for (int i=0;i<M;i++){
            st[i]=new HashMap<>();
        }
    }

    public SeparateTable(){
        this(997);
    }

    private int hash(Key key){
        return (key.hashCode()& 0x7fffffff)%M;
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key,Value val){
        st[hash(key)].put(key,val);
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (Key key:st[i].keySet()){
                queue.add(key);
            }
        }
        return queue;
    }

}
