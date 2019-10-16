package New.Graph;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.ArrayList;

public class PrimMST {
    //约定
    //如果顶点v不在树中但至少含有一条边和树相连，那么edgeTo[v] 是将v和树连接的最短边，distTo[v]为这条边的权重
    private Edge[] edgeTo; //距离树最近的边
    private double[] distTo; //distTo[w]=edgeTo[w].weight
    //所有这类顶点v都保存在一条索引优先队列中，索引v 关联的值是edgeTo[v] 的边的权重
    private boolean[] marked; //如果v 在树中则为true
    private IndexMinPQ<Double> pq; //有效的横切边

    public PrimMST(EdgeWeightedGraph G){
        edgeTo=new Edge[G.V()];
        distTo=new double[G.V()];
        marked=new boolean[G.V()];

        //将到每个点的距离初始化为最大值，表示不可达
        for (int v=0;v<G.V();v++){
            distTo[v]=Double.POSITIVE_INFINITY;
        }

        pq=new IndexMinPQ<>(G.V());
        distTo[0]=0.0;
        pq.insert(0,0.0);
        while (!pq.isEmpty())
        {
            visit(G,pq.delMin());
        }
    }


    private void visit(EdgeWeightedGraph G,int v){
        //将顶点v 添加到树中，更新数据
        marked[v]=true;
        for (Edge e:G.adj(v)){
            int w=e.other(v);
            if (marked[w]) continue; //v-w 失效
            if (e.weight()<distTo[w]){
                //连接w和树的最佳边 Edge变为e
                edgeTo[w]=e;
                distTo[w]=e.weight();
                if (pq.contains(w)) pq.change(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        ArrayList<Edge>  list=new ArrayList();
        for (int v=1;v<edgeTo.length;v++){
            list.add(edgeTo[v]);
        }
        return list;
    }
}
