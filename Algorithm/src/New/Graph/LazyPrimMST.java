package New.Graph;

import edu.princeton.cs.algs4.MinPQ;

import java.util.LinkedList;
import java.util.Queue;

public class LazyPrimMST {
    private boolean[] marked; //最小生成树的顶点
    private Queue<Edge> mst; //最小生成树的边
    private MinPQ<Edge> pq;//横切边(包括失效的边)

    public LazyPrimMST(EdgeWeightedGraph G){
        pq=new MinPQ<>();
        marked=new boolean[G.V()];
        mst=new LinkedList<>();

        visit(G,0); //假设G是连通的
        while (!pq.isEmpty()){
            Edge e=pq.delMin(); //从pq中得到最小的边

            //下面两步是跳过重复的边
            int v=e.either(),w=e.other(v);
            if (marked[v] && marked[w])continue;

            mst.add(e); //将边添加到最小生成树中

            if (!marked[v]) visit(G,v);
            if (!marked[w]) visit(G,w);
        }
    }

    private void visit(EdgeWeightedGraph G,int v){
        //标记顶点v并将所有连接 v 和未被标记顶点的边加入pq
        marked[v]=true;
        for (Edge e: G.adj(v)){
            if (!marked[e.other(v)])
               pq.insert(e);
        }
    }

    private Iterable<Edge> edges(){
        return mst;
    }
}
