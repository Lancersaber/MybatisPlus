package New.Graph;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {

    public static void main(String[] args){
        Graph graph=new Graph(6);
        graph.setE(5);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
//        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        DepthFirstPaths depthFirstPaths=new DepthFirstPaths(graph,0);
        Iterable<Integer> iterable = depthFirstPaths.pathTo(5);
        Iterator<Integer> iterator = iterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private boolean[] marked; //这个顶点调用过dfs() 了吗
    private int[] edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; //起点

    public DepthFirstPaths(Graph G,int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        // v 这个顶点已经访问
        marked[v]=true;
        for (int w:G.adj(v)){
            if (!marked[w]){ //如果 w 没有被访问过
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path=new Stack<>();
        for (int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        return path;
    }
}
