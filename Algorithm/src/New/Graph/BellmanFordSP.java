package New.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BellmanFordSP {
    private double[] distTo; //从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo; //从起点到某个顶点的最后一条边
    private boolean[] onQ;//该顶点是否在队列中
    private Queue<Integer> queue; //正在被放松的顶点
    private int cost; //relax()的调用次数
    private Iterable<DirectedEdge> cycle; //edgeTo中的是否有负权重环

    public BellmanFordSP(EdgeWeightedDigraph G,int s){
        distTo=new double[G.V()];
        edgeTo=new DirectedEdge[G.V()];
        onQ=new boolean[G.V()];
        queue=new LinkedList<>();
        for (int v=0;v<G.V();v++){
            distTo[v]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0.0;
        queue.add(s);
        onQ[s]=true;
        while (!queue.isEmpty() && !this.hasNegativeCycle()){
            int v=queue.poll();
            onQ[v]=false;
            relax(G,v);
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){

    }

    private void findNegativeCycle(){

    }

    public boolean hasNegativeCycle(){
        return false;
    }

    public Iterable<Edge> negativeCycle(){
        return null;
    }
}
