package New.Graph;

import java.util.Stack;

//无环加权有向图的最短路径算法
//有向无环图（DAG）才有拓扑排序，非DAG图没有拓扑排序一说。
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G,int s){
        edgeTo=new DirectedEdge[G.V()];
        distTo=new double[G.V()];

        for (int v=0;v<G.V();v++){
            distTo[v]=Double.POSITIVE_INFINITY;
        }

        distTo[s]=0.0;
        //这里有点小问题，编写的 Topogical 没有以 EdgeWeightedDigraph 为参数的构造参数
        Topogical top=new Topogical(G);//并没有实现这个构造函数

        for (int v:top.order()){

        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for (DirectedEdge e: G.adj(v)){
            int w=e.to();
            if (distTo[w]>distTo[v]+e.weight()){
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path=new Stack<>();

        for (DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()])
            path.push(e);
        return path;
    }
}
