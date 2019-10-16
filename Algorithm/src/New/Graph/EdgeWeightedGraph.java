package New.Graph;

import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;
//加权无向图
public class EdgeWeightedGraph {
    private final int V; //顶点总数
    private int E;// 边的总数
    private ArrayList<Edge>[] adj; //邻接表

    public EdgeWeightedGraph(int V){
        this.V=V;
        this.E=0;
        adj=new ArrayList[V];
        for (int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b=new Bag<>();
        for (int v=0;v<V;v++){
            for (Edge e:adj[v])
                if (e.other(v)>v)  //这样写每条边就只会被加入一次
                    b.add(e);
        }
        return b;
    }

}
