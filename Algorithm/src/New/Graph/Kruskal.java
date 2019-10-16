package New.Graph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

import java.util.LinkedList;
import java.util.Queue;

public class Kruskal {
    private Queue<Edge> mst;

    public Kruskal(EdgeWeightedGraph G){
        mst=new LinkedList<>();
        //这里需要把图中的所有边都加入到pq中
        MinPQ<Edge> pq=new MinPQ<Edge>();
        UF uf=new UF(G.V());

        while (!pq.isEmpty() && mst.size()<G.V()-1){
            Edge e=pq.delMin(); //从pq得到权重最小的边和它的顶点
            int v=e.either(),w=e.other(v);
            if (uf.connected(v,w)) continue; //忽略失效的边
            uf.union(v,w); //合并分量
            mst.add(e); //将边添加到最小生成树中
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double weight=0.0;
        for (Edge e:mst){
            weight+=e.weight();
        }

        return weight;
    }
}
