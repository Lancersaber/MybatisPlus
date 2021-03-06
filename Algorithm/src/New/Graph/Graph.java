package New.Graph;

import java.util.ArrayList;

public class Graph {
    private final int V; //顶点数目
    private int E; //边的数目
    private ArrayList<Integer>[] adj; //邻接表

    public Graph(int v){
        this.V=v;
        adj=new ArrayList[v]; //创建邻接表
        for (int i=0;i<v;i++){
            adj[i]=new ArrayList<>();
        }
    }

    public void setE(int E){
        this.E=E;
    }

    public int V() {
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w); //将w添加到v的链表中
        adj[w].add(v); //将w添加到v的链表中
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }


}
